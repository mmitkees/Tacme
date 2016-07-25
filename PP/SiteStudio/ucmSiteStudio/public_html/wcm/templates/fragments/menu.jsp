<?xml version='1.0' encoding='UTF-8'?>
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page" version="2.1"
xmlns:wcm="http://www.oracle.com/jsp/wcm"
xmlns:c="http://java.sun.com/jsp/jstl/core"
xmlns:fn="http://java.sun.com/jsp/jstl/functions">
<div id="menu">
<ul id="nav">
<li>
<wcm:url var="root" type="node"
url="${wcmContext.project.structure.rootSection.ID}"/>
<a href="${root}">
${wcmContext.project.structure.rootSection.properties.label}
</a>
</li>
<c:set var="sections"
value="${wcmContext.project.structure.rootSection.activeChildren}"/>
<!-- Iterate through the site structure nodes and add them to the menu -->
<c:forEach var="section" items="${sections}">
<wcm:url var="sectionUrl" type="node" url="${section.ID}"/>
<li>
<a title="${section.properties.label}" href="${sectionUrl}">
<em>
${fn:substring(section.properties.label, 0, 1)}
</em>
${fn:substring(section.properties.label, 1, -1)}
</a>
</li>
</c:forEach>
</ul>
<br class="clear"/>
</div>
</jsp:root>