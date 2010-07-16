/**
 * 
 */
package org.nuxeo.ide.builder.manifest;

public class DirectiveTransformerVeto extends Exception {

	private static final long serialVersionUID = 1L;
	
	public final DirectiveInfo info;
	public final DirectiveTransformer veto;
	
	DirectiveTransformerVeto(DirectiveTransformer veto, DirectiveInfo info) {
		this.veto = veto;
		this.info = info;
	}
}