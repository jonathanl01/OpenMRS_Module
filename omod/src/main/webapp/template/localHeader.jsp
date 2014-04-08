<h2><spring:message code="basicmodule.title"/></h2>

<ul id="menu">
	<li class="first<c:if test='<%= request.getRequestURI().contains("privacyPatient") %>'> active</c:if>">
		<a href="privacyPatient.htm"><spring:message code="basicmodule.menu.patient"/></a>
	</li>
	<li class="test<c:if test='<%= request.getRequestURI().contains("user") %>'> active</c:if>">
		<a href="user.htm"><spring:message code="basicmodule.menu.user"/></a>
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