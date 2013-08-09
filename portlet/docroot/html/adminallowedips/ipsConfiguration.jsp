<%@ include file="/html/init.jsp" %>

<portlet:actionURL name="saveIpsConfiguration" var="saveIpsConfigurationURL" />

<%
long groupId = themeDisplay.getScopeGroupId();
long companyId = themeDisplay.getCompanyId();
long userId = themeDisplay.getUserId();
String redirect = ParamUtil.getString(request, "redirect");

AdminIPConfiguration configuration = null;
Layout selectedLayout = null;
configuration = AdminIPConfigurationLocalServiceUtil.getAdminIPConfiguration();
%>

<aui:model-context bean="<%= configuration %>" model="<%= gr.open.marketplace.model.AdminIPConfiguration.class %>" />

<aui:form action="<%=saveIpsConfigurationURL.toString()%>" method="post">
	<aui:input name="id" type="hidden"/>
	
	<aui:fieldset>
		<aui:input name="redirectUrl" helpMessage="redirect-url-fieldset-help" >
			<aui:validator name="required" />
		</aui:input>
	</aui:fieldset>
	
	<aui:fieldset>
		<aui:input name="debug" label="debug" helpMessage="debug-fieldset-help" />
	</aui:fieldset>
	
	<aui:fieldset>
		<aui:select name="mode" helpMessage="mode-fieldset-help">
			<option value="<%= Constants.MODE_BOTH %>" <%=configuration.getMode() == Constants.MODE_BOTH?"selected='selected'":"" %>><liferay-ui:message key="mode.both"/></option>
			<option value="<%= Constants.MODE_LOGIN %>" <%=configuration.getMode() == Constants.MODE_LOGIN?"selected='selected'":"" %>><liferay-ui:message key="mode.login"/></option>
			<option value="<%= Constants.MODE_CONTROL_PANEL %>" <%=configuration.getMode() == Constants.MODE_CONTROL_PANEL?"selected='selected'":"" %>><liferay-ui:message key="mode.control.panel"/></option>
		</aui:select>
	</aui:fieldset>
	
	<aui:button-row>
		<aui:button type="submit" />
	</aui:button-row>
</aui:form>