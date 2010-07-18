<#ftl ns_prefixes={"pom":"http://maven.apache.org/POM/4.0.0"}/>
<#recurse doc>
<#macro "pom:project"><project xmlns="${.node?node_namespace}" ${.node.@@attributes_markup}><#recurse></project></#macro>
<#macro @text><#assign text=.node.@@text m=.node.@@text?matches(originalLabel) parent=.node?parent?node_name gparent=.node?parent?parent?node_name><#if parent == "version" && gparent == "parent" && m>${m?groups[1]}${newLabel}<#elseif parent == "version" && gparent == "project" && m>${m?groups[1]}${newLabel}<#elseif gparent == "properties" && m>${m?groups[1]}${newLabel}<#else>${text}</#if></#macro>
<#macro @element><${.node?node_name}<#if .node.@@attributes_markup??> ${.node.@@attributes_markup}</#if>><#recurse></${.node?node_name}></#macro>
