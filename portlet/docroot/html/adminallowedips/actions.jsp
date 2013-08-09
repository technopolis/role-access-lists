
<%@ include file="/html/init.jsp" %>

<%
ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
AdminIPValidationData data = (AdminIPValidationData)row.getObject();

String redirect = PortalUtil.getCurrentURL(renderRequest);
long companyId = PortalUtil.getDefaultCompanyId();
Group guestGroup = GroupLocalServiceUtil.getGroup(companyId,GroupConstants.GUEST);
long defaultUserId = UserLocalServiceUtil.getDefaultUserId(companyId);

%>
<liferay-ui:icon-menu >


	<portlet:renderURL var="editDataURL">
		<portlet:param name="jspPage" value="/html/adminallowedips/edit.jsp" />
		<portlet:param name="id" value="<%=String.valueOf(data.getId()) %>"/>
		<portlet:param name="redirect" value="<%= redirect %>" />
	</portlet:renderURL>
	<liferay-ui:icon image="view_tasks" message="edit-data" url='<%=editDataURL %>' />

	<%-- DELETE --%>
	<portlet:actionURL name="delete" var="deleteURL">
		<portlet:param name="id" value="<%=String.valueOf(data.getId()) %>"/>
		<portlet:param name="redirect" value="<%= redirect %>"/>
	</portlet:actionURL>
<%
String deletejavascript = "javascript:if (confirm(ote_portlet_delete_menuItemConfiguration_message)) { window.location = '"+ deleteURL + "'; } else { self.focus(); }";
%>
	<liferay-ui:icon image="delete" url="<%= deletejavascript%>" />
<script>
var ote_portlet_delete_menuItemConfiguration_message = '<liferay-ui:message key="are-you-sure"/>';
</script>

</liferay-ui:icon-menu>