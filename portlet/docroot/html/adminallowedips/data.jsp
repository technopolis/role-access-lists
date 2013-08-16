<%@page import="java.util.Iterator"%>
<%@page import="java.util.HashMap"%>
<%@page import="gr.open.marketplace.comparators.CustomComparatorHelper"%>
<%@page import="com.liferay.portal.kernel.util.OrderByComparator"%>
<%@page import="com.liferay.portlet.PortalPreferences"%>
<%@page import="com.liferay.portlet.PortletPreferencesFactory"%>
<%@ include file="/html/init.jsp" %>
<%
String redirect = PortalUtil.getCurrentURL(renderRequest);

int active = ParamUtil.getInteger(request, "active", gr.open.marketplace.Constants.ACTIVE_ALL);
int debugMode = ParamUtil.getInteger(request, "debugMode", gr.open.marketplace.Constants.DEBUG_MODE_ALL);
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
			<aui:fieldset column="true">
				<aui:select name="active" helpMessage="active-filter">
					<option  value="<%=gr.open.marketplace.Constants.ACTIVE_ALL %>" <%=active == gr.open.marketplace.Constants.ACTIVE_ALL?"selected='selected'":"" %>><liferay-ui:message key="active.all"/></option>
					<option   value="<%=gr.open.marketplace.Constants.ACTIVE_ONLY_INACTIVE %>" <%=active == gr.open.marketplace.Constants.ACTIVE_ONLY_INACTIVE?"selected='selected'":"" %>><liferay-ui:message key="active.onlyInactive"/></option>
					<option   value="<%=gr.open.marketplace.Constants.ACTIVE_ONLY_ACTIVE %>" <%=active == gr.open.marketplace.Constants.ACTIVE_ONLY_ACTIVE?"selected='selected'":"" %>><liferay-ui:message key="active.onlyActive"/></option>
				</aui:select>
			</aui:fieldset>
			
			<aui:fieldset column="true" style="padding-left: 20px;">
				<aui:select name="debugMode" helpMessage="debugMode-filter">
					<option  value="<%=gr.open.marketplace.Constants.DEBUG_MODE_ALL %>" <%=debugMode == gr.open.marketplace.Constants.DEBUG_MODE_ALL?"selected='selected'":"" %>><liferay-ui:message key="debugMode.all"/></option>
					<option   value="<%=gr.open.marketplace.Constants.DEBUG_MODE_ONLY_INACTIVE %>" <%=debugMode == gr.open.marketplace.Constants.DEBUG_MODE_ONLY_INACTIVE?"selected='selected'":"" %>><liferay-ui:message key="debugMode.onlyInactive"/></option>
					<option   value="<%=gr.open.marketplace.Constants.DEBUG_MODE_ONLY_ACTIVE %>" <%=debugMode == gr.open.marketplace.Constants.DEBUG_MODE_ONLY_ACTIVE?"selected='selected'":"" %>><liferay-ui:message key="debugMode.onlyActive"/></option>
				</aui:select>
			</aui:fieldset>
			
			<aui:fieldset column="true" style="padding-left: 20px;">
				<aui:select name="selectedRoleId"  helpMessage="role-filter">
				<option value="0"><liferay-ui:message key="no-selection"/></option>
				<c:set value="<%=selectedRoleId %>" var="selectedRoleId" ></c:set>
				<c:forEach items="${roles }" var="role">
					<option value="${role.roleId }" ${role.roleId == selectedRoleId ? "selected='selected'":"" }>${role.name}</option>
				</c:forEach>
				</aui:select>
			</aui:fieldset>
			
			<aui:fieldset column="true" style="padding-left: 20px;">
				<aui:input name="ip" value="<%=ip %>" helpMessage="ip-filter"></aui:input>
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
	
	PortalPreferences portalPrefs = PortletPreferencesFactoryUtil.getPortalPreferences(request); 
	String sortByCol = ParamUtil.getString(request, "orderByCol"); 
	String sortByType = ParamUtil.getString(request, "orderByType"); 
	    
	if (Validator.isNotNull(sortByCol ) && Validator.isNotNull(sortByType )) { 
	 
		portalPrefs.setValue("NAME_SPACE", "sort-by-col", sortByCol); 
		portalPrefs.setValue("NAME_SPACE", "sort-by-type", sortByCol); 
	 
	} else { 
	 
		sortByCol = portalPrefs.getValue("NAME_SPACE", "sort-by-col", "First Name");
		sortByType = portalPrefs.getValue("NAME_SPACE", "sort-by-type ", "asc");   
	}
%>

<liferay-ui:search-container 
		delta='20' 
		emptyResultsMessage="providerFeed-empty-results-message"
		orderByCol="<%=sortByCol %>"
		orderByType="<%=sortByType %>"
>
<%
        PortletURL iteratorURL= renderResponse.createRenderURL();
        Map<String,String> paramMap= new HashMap <String,String>();
        paramMap.put("active", String.valueOf(active));
        paramMap.put("ip", ip);
        paramMap.put("selectedRoleId", String.valueOf(selectedRoleId));
		Iterator<Map.Entry<String, String>> entries = paramMap.entrySet().iterator();
		while (entries.hasNext()) {
			Map.Entry<String, String> entry = entries.next();
			iteratorURL.setParameter(entry.getKey(), entry.getValue());
		}
		searchContainer.setIteratorURL(iteratorURL);
%>

	<liferay-ui:search-container-results 
			results="<%= AdminIPValidationDataLocalServiceUtil.getAdminIPValidationData(themeDisplay.getCompanyId(), ip, active, debugMode, selectedRoleId, searchContainer.getStart(), searchContainer.getEnd(), CustomComparatorHelper.getDataOrderByComparator(sortByCol, sortByType))  %>"
			total="<%= AdminIPValidationDataLocalServiceUtil.getAdminIPValidationDataCount(themeDisplay.getCompanyId(), ip, active, debugMode, selectedRoleId) %>"/>
	
	<liferay-ui:search-container-row
			className="gr.open.marketplace.model.AdminIPValidationData"
			keyProperty="id"
			modelVar="data" 
			escapedModel="false">
		
		<liferay-ui:search-container-column-text name="Is Active"	align="center" orderableProperty="active" orderable="true">
			 <%
 				String dataActiveIcon = iconUnchecked;
  				if (data.isActive()) {
  					dataActiveIcon = iconChecked;
 				}
 			  %>
			<liferay-ui:icon image="<%=dataActiveIcon %>"/>
		</liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text name="debug-mode" align="center" orderableProperty="debug" orderable="true">
			 <%
 				String dataDebugIcon = iconUnchecked;
  				if (data.isDebugMode()) {
  					dataDebugIcon = iconChecked;
 				}
 			  %>
			<liferay-ui:icon image="<%=dataDebugIcon %>"/>
		</liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text orderable="false" property="ipsForTable"/>
		<liferay-ui:search-container-column-text orderable="false" property="rolesForView" />
		<liferay-ui:search-container-column-text orderable="true" property="createDateForView" orderableProperty="createDate"/>
		<liferay-ui:search-container-column-text orderable="true" property="modifiedDateForView" orderableProperty="modifiedDate"/>
		<liferay-ui:search-container-column-text orderable="true" property="userEmailForView" orderableProperty="userEmail" />
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
