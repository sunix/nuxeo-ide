/**
 * 
 */
package org.nuxeo.ide.builder.manifest;

public class DirectiveInfo {
	public final String name;
	public final String value;
	
	DirectiveInfo(String name, String value) {
		this.name = name;
		this.value = value;
	}
	
	@Override
	public String toString() {
		return String.format("DirectiveInfo:[%s=%s]", name, value);
	}
}