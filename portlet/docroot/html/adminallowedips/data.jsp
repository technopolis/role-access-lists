<%@ include file="/html/init.jsp" %>
<%
String redirect = PortalUtil.getCurrentURL(renderRequest);

int active = ParamUtil.getInteger(request, "active", -1);
String ip = ParamUtil.getString(request, "ip", "");
long selectedRoleId = ParamUtil.getLong(request, "selectedRoleId", 0);
%>
<portlet:renderURL var="submitFilterFormURL"></portlet:renderURL>

<portlet:renderURL var="addDataURL">
	<portlet:param name="jspPage" value="/html/adminallowedips/edit.jsp" />
	<portlet:param name="redirect" value="<%= redirect %>" />
</portlet:renderURL>

<div id="myToggler">
	<div class="content">
		<aui:form name="filterForm" action="<%= submitFilterFormURL%>" method="post">
			<aui:fieldset>
				<aui:select name="active" helpMessage="active-filter">
					<option  value="<%=gr.open.marketplace.Constants.ACTIVE_ALL %>" <%=active == gr.open.marketplace.Constants.ACTIVE_ALL?"selected='selected'":"" %>><liferay-ui:message key="active.all"/></option>
					<option   value="<%=gr.open.marketplace.Constants.ACTIVE_ONLY_INACTIVE %>" <%=active == gr.open.marketplace.Constants.ACTIVE_ONLY_INACTIVE?"selected='selected'":"" %>><liferay-ui:message key="active.onlyInactive"/></option>
					<option   value="<%=gr.open.marketplace.Constants.ACTIVE_ONLY_ACTIVE %>" <%=active == gr.open.marketplace.Constants.ACTIVE_ONLY_ACTIVE?"selected='selected'":"" %>><liferay-ui:message key="active.onlyActive"/></option>
				</aui:select>
				<aui:input name="ip" value="<%=ip %>" helpMessage="ip-filter"></aui:input>
				
				<aui:select name="selectedRoleId"  helpMessage="role-filter">
				<option value="0"><liferay-ui:message key="no-selection"/></option>
				<c:set value="<%=selectedRoleId %>" var="selectedRoleId" ></c:set>
				<c:forEach items="${roles }" var="role">
					<option value="${role.roleId }" ${role.roleId == selectedRoleId ? "selected='selected'":"" }>${role.name}</option>
				</c:forEach>
				</aui:select>
			</aui:fieldset>
		
			<aui:button-row>
				<aui:button  type="submit" value="Filter"></aui:button>
				<aui:button name="add" value="addEntry" href="<%= addDataURL %>"></aui:button>
			</aui:button-row>
		</aui:form>
	</div>
</div>
<%
	String iconChecked = "checked";
	String iconUnchecked = "unchecked";
%>

<liferay-ui:search-container delta='20' emptyResultsMessage="providerFeed-empty-results-message">
	<liferay-ui:search-container-results
			results="<%= AdminIPValidationDataLocalServiceUtil.getAdminIPValidationData(themeDisplay.getCompanyId(), ip, active, selectedRoleId, searchContainer.getStart(), searchContainer.getEnd())  %>"
			total="<%= AdminIPValidationDataLocalServiceUtil.getAdminIPValidationDataCount(themeDisplay.getCompanyId(), ip, active, selectedRoleId) %>"/>
	
	<liferay-ui:search-container-row
			className="gr.open.marketplace.model.AdminIPValidationData"
			keyProperty="id"
			modelVar="data" 
			escapedModel="false">
		
		<liferay-ui:search-container-column-text name="Is Active"	align="center" >
			 <%
 				String dataActiveIcon = iconUnchecked;
  				if (data.isActive()) {
  					dataActiveIcon = iconChecked;
 				}
 			  %>
			<liferay-ui:icon image="<%=dataActiveIcon %>"/>
		</liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text orderable="false" property="ipsForTable"/>
		<liferay-ui:search-container-column-text orderable="false" property="rolesForView" />
		<liferay-ui:search-container-column-text orderable="false" property="createDateForView" />
		<liferay-ui:search-container-column-text orderable="false" property="modifiedDateForView" />
		<liferay-ui:search-container-column-text orderable="false" property="userEmailForView" />
		<liferay-ui:search-container-column-text orderable="false" property="notes"/>
		<liferay-ui:search-container-column-jsp align="right" path="/html/adminallowedips/actions.jsp"/>

	</liferay-ui:search-container-row>
	
	<liferay-ui:search-iterator />
	
</liferay-ui:search-container>

<aui:script>
AUI().ready(
  'aui-tooltip',
  function(A) {
    new A.Tooltip(
      {
        title: true,
        trigger: '.hasTooltip'
      }
    ).render();
  }
);
</aui:script>
