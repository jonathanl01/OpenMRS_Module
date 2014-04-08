<!-- Written by: Kirill -->
<%@ include file="/WEB-INF/template/include.jsp"%>

<!--<openmrs:require privilege="View Patient Privacy Records" otherwise="/login.htm" redirect="/module/usagestatistics/users.htm"/>-->

<%@ include file="/WEB-INF/template/header.jsp"%>

<%@ include file="template/localInclude.jsp" %>
<%@ include file="template/localHeader.jsp" %>

<b class="boxHeader">
	<spring:message code="basicmodule.patient.title"/>
</b>
<form method="get" class="box">

	<table cellpadding="2" cellspacing="0" width="100%">
		<tr>
			<td align="left">
				<spring:message code="basicmodule.query.from" />

				<ustats_tag:dateRange fromField="from" fromValue="${from}" untilField="until" untilValue="${until}" />
				
				<spring:message code="basicmodule.query.byPatient"/>

                                <openmrs_tag:patientField formFieldName="patientId" searchLabelCode="Patient.find" initialValue="${model.patient.patientId}" linkUrl="${pageContext.request.contextPath}/admin/patients/patient.form"/>	
                                <input style="width: 16px" type="button" class="smallButton" id="clearUserBtn" onclick="document.usagesForm.patientId.value='';document.usagesForm.submit();" value="X" />
				
                                <spring:message code="basicmodule.query.with"/>
				
				<ustats_tag:usageFilter formFieldName="usageFilter" initialValue="${usageFilter}" />
				
				<spring:message code="basicmodule.query.type"/>
			</td>
			<td align="right">
				<input type="submit" value="<spring:message code="basicmodule.query.update"/>" />
				<input type="submit" name="export" value="<spring:message code="basicmodule.query.export"/>" />
			</td>
		</tr>
	</table>
		
	<table cellpadding="2" cellspacing="0" width="100%">
		<tr>
			<th><spring:message code="basicmodule.results.date"/></th>
			<th align="center"><spring:message code="basicmodule.results.user"/></th>
			<th align="center"><spring:message code="basicmodule.results.patient"/></th>
			<th align="center"><spring:message code="basicmodule.results.type"/></th>
		</tr>
		<c:forEach items="${stats}" var="row" varStatus="rowStatus">
			<tr class="<c:choose><c:when test="${rowStatus.index % 2 == 0}">evenRow</c:when><c:otherwise>oddRow</c:otherwise></c:choose>">
				<td><a href="users.htm?from=${ustats:formatDate(from)}&amp;until=${ustats:formatDate(until)}&amp;locationId=${param.locationId}&amp;role=${fn:replace(row[0], ' ', '%20')}">${row[0]}</a></td>
				<td align="center">${row[1]}</td>
				<td align="center">${row[2]}</td>
				<td align="center">${row[3]}</td>
				<td align="center">${row[4]}</td>
				<td align="center">${row[5]}</td>
				<td align="center">${row[6]}</td>
				<td align="center">${ustats:formatDate(row[7])}</td>
			</tr>	
		</c:forEach>
		<c:if test="${empty stats}">
			<tr>
				<td colspan="8" style="padding: 10px; text-align: center"><spring:message code="basicmodule.noresults"/></td>
			</tr>
		</c:if>
	</table>
	
</form>

<%@ include file="/WEB-INF/template/footer.jsp"%>