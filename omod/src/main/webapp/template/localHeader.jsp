<h2><spring:message code="basicmodule.title"/></h2>

<ul id="menu">
	<li class="first<c:if test='<%= request.getRequestURI().contains("patientAccess") %>'> active</c:if>">
		<a href="patientAccess.htm"><spring:message code="basicmodule.menu.patient"/></a>
	</li>
	<li class="test<c:if test='<%= request.getRequestURI().contains("userAccess") %>'> active</c:if>">
		<a href="userAccess.htm"><spring:message code="basicmodule.menu.user"/></a>
	</li>
	<li class="test<c:if test='<%= request.getRequestURI().contains("order") %>'> active</c:if>">
		<a href="order.htm"><spring:message code="basicmodule.menu.order"/></a>
	</li>
	<li class="test<c:if test='<%= request.getRequestURI().contains("encounter") %>'> active</c:if>">
		<a href="encounter.htm"><spring:message code="basicmodule.menu.encounter"/></a>
	</li>
	<li class="test<c:if test='<%= request.getRequestURI().contains("visit") %>'> active</c:if>">
		<a href="visit.htm"><spring:message code="basicmodule.menu.visit"/></a>
	</li>
</ul>