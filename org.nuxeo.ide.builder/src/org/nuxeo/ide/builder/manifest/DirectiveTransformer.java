/**
 *
 */
package org.nuxeo.ide.builder.manifest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


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
		public DirectiveInfo process(DirectiveInfo info)
				throws DirectiveTransformerVeto {
			return invokeNext(info);
		}

	}

	public static DirectiveTransformer multiValuesPrettyPrinter() {
		return new MultiValuesPrettyPrinter();
	}

	static class MultiValuesPrettyPrinter extends DirectiveTransformer {

		public static final String LS = System.getProperty("line.separator");

		@Override
		public DirectiveInfo process(DirectiveInfo info)
				throws DirectiveTransformerVeto {
			String hr = info.value.replaceAll(",", ","+LS+" ");
			if (!hr.startsWith(" ")) {
				hr = " " + hr;
			}
			return invokeNext(new DirectiveInfo(info.name, hr));
		}

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
		public DirectiveInfo process(DirectiveInfo info)
				throws DirectiveTransformerVeto {
			if (name.equals(info.name)) {
				throw new DirectiveTransformerVeto(this, info);
			}
			return invokeNext(info);
		}
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
		protected DirectiveInfo process(DirectiveInfo info)
				throws DirectiveTransformerVeto {
			if (!"Export-Package".equals(info.name)) {
				return invokeNext(info);
			}
			DirectiveInfo transformed = invokeNext(info);
			return new DirectiveInfo(transformed.name,
					transformed.value.replaceAll(expression, ""));
		}


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
		protected DirectiveInfo process(DirectiveInfo info)
				throws DirectiveTransformerVeto {
			if ("Bundle-Version".equals(info.name)) {
				info = new DirectiveInfo(info.name, label);
			}
			return invokeNext(info);
		}

	}

}