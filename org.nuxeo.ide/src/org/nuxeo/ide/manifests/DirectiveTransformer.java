/**
 *
 */
package org.nuxeo.ide.manifests;

import static org.junit.Assert.assertEquals;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

public abstract class DirectiveTransformer {

    static final Log log = LogFactory.getLog(DirectiveTransformer.class);

    protected DirectiveTransformer next;

    public DirectiveTransformer link(DirectiveTransformer next) {
        return this.next = next;
    }

    protected DirectiveInfo invokeNext(DirectiveInfo info) throws DirectiveTransformerVeto {
        if (next == null) {
            return info;
        }
        return next.process(info);
    }

    protected abstract DirectiveInfo process(DirectiveInfo info) throws DirectiveTransformerVeto;

    public static DirectiveTransformer noop() {
        return new Noop();
    }

    public static class Noop extends DirectiveTransformer {

        @Override
        public DirectiveInfo process(DirectiveInfo info) throws DirectiveTransformerVeto {
            return invokeNext(info);
        }

    }

    public static DirectiveTransformer multiValuesPrettyPrinter() {
        return new MultiValuesPrettyPrinter();
    }

    static class MultiValuesPrettyPrinter extends DirectiveTransformer {

        public static final String LS = System.getProperty("line.separator");

        @Override
        public DirectiveInfo process(DirectiveInfo info) throws DirectiveTransformerVeto {
            String hr = info.value.replaceAll(",", "," + LS + " ");
            if (!hr.startsWith(" ")) {
                hr = " " + hr;
            }
            return invokeNext(new DirectiveInfo(info.name, hr));
        }

    }

    @Test
    public void testMultiValues() throws DirectiveTransformerVeto {
        DirectiveTransformer transf = new DirectiveTransformer.MultiValuesPrettyPrinter();
        DirectiveInfo info = transf.process(new DirectiveInfo("test", "toto,titi"));
        assertEquals("name is altered", "test", info.name);
        assertEquals("line is not pretty printed", " toto,\n titi", info.value);
    }

    public static DirectiveTransformer nameVeto(String name) {
        return new NameVeto(name);
    }

    static class NameVeto extends DirectiveTransformer {

        public NameVeto(String name) {
            this.name = name;
        }

        String name;

        @Override
        public DirectiveInfo process(DirectiveInfo info) throws DirectiveTransformerVeto {
            if (name.equals(info.name)) {
                throw new DirectiveTransformerVeto(this, info);
            }
            return invokeNext(info);
        }
    }

    @Test(expected = DirectiveTransformerVeto.class)
    public void testNameVeto() throws DirectiveTransformerVeto {
        DirectiveTransformer nameVeto = new DirectiveTransformer.NameVeto("pfff");
        nameVeto.process(new DirectiveInfo("pfff", ""));
    }

    public static DirectiveTransformer logger() {
        return new Logger();
    }

    static class Logger extends DirectiveTransformer {

        public DirectiveInfo process(DirectiveInfo source) throws DirectiveTransformerVeto {
            try {
                DirectiveInfo transformed = invokeNext(source);
                log.info(source + " -> " + transformed);
                return transformed;
            } catch (DirectiveTransformerVeto veto) {
                log.info("veto on " + veto.info);
                throw veto;
            }

        }
    }

    public static DirectiveTransformer exportPackagesVersionEraser(String label) {
        return new ExportPackageVersionEraser(label);
    }

    public static class ExportPackageVersionEraser extends DirectiveTransformer {

        String label;

        String expression;

        public ExportPackageVersionEraser(String label) {
            this.label = label;
            this.expression = String.format(";version=\"%s\"", label);
        }

        @Override
        protected DirectiveInfo process(DirectiveInfo info) throws DirectiveTransformerVeto {
            if (!"Export-Package".equals(info.name)) {
                return invokeNext(info);
            }
            DirectiveInfo transformed = invokeNext(info);
            return new DirectiveInfo(transformed.name, transformed.value.replaceAll(expression, ""));
        }

    }

    @Test
    public void testExportPackagesVersionEraser() throws DirectiveTransformerVeto {
        ExportPackageVersionEraser eraser = new ExportPackageVersionEraser("1.6.2.SNAPSHOT");
        DirectiveInfo original = new DirectiveInfo("Export-Package", " org.nuxeo;version=\"1.6.2.SNAPSHOT\",\n org.nuxeo.other;version=\"1.6.2.SNAPSHOT\"\n");
        DirectiveInfo info = eraser.process(original);
        assertEquals("incorrect packages", " org.nuxeo,\n org.nuxeo.other\n", info.value);
    }

    public static DirectiveTransformer bundleVersionOverwriter(String label) {
        return new BundleVersionOverwriter(label);
    }

    public static class BundleVersionOverwriter extends DirectiveTransformer {

        final String label;

        public BundleVersionOverwriter(String label) {
            this.label = label;
        }

        @Override
        protected DirectiveInfo process(DirectiveInfo info) throws DirectiveTransformerVeto {
            if ("Bundle-Version".equals(info.name)) {
                info = new DirectiveInfo(info.name, label);
            }
            return invokeNext(info);
        }

    }

}