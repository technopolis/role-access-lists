<%@ include file="/html/init.jsp" %>

<%
long groupId = themeDisplay.getScopeGroupId();
long companyId = themeDisplay.getCompanyId();
long userId = themeDisplay.getUserId();
String redirect = ParamUtil.getString(request, "redirect");

AdminIPValidationData data = null;
Layout selectedLayout = null;
long id = ParamUtil.getLong(renderRequest, "id");
if (id > 0) {
	data = AdminIPValidationDataLocalServiceUtil.getAdminIPValidationData(id);
}

List<Role> roles = RoleLocalServiceUtil.getRoles(themeDisplay.getCompanyId());
if (data != null) {
	System.out.println("DATA:" + data);
	System.out.println("DATA roles:" + data.getRolesAsArray());
	System.out.println("DATA ips:" + data.getIpsAsArray());
}
%>

<liferay-ui:header
	backURL="<%= redirect %>"
	title='<%= (data != null) ? "edit" : "add" %>'
/>
<portlet:actionURL name="saveEntry" var="saveEntryURL" />

<liferay-ui:error key="error-key" message="error-in-roles" />
<liferay-ui:error key="error-key" message="error-in-ips" />
<liferay-ui:error key="error-key" message="error-in-redirect-url" />

<aui:model-context bean="<%= data %>" model="<%= gr.open.marketplace.model.AdminIPValidationData.class %>" />
<aui:form action="<%=saveEntryURL.toString()%>" method="post" name="fm">
	<aui:fieldset helpMessage="ips-fieldset-help" label="IPs">
		<%-- HIDDEN FIELDS --%>
		<aui:input name="id" type="hidden" value="<%=id %>"/>
		
		<%-- FIELDS --%>
		<aui:select name="ipAddresses" multiple="true" label="">
		<%
			if (data != null) {
				for (String ip : data.getIpsAsArray()) { 
					if (ip != null) {
		%>
			<option selected='selected' value="<%=ip %>"><%= ip%></option>
		<%
					}
				}
			}
		%>
		</aui:select>
		<div style="padding-top:10px;"></div>
		<input style="padding:4px;" maxlength="3" size="3" min="1" max="3" id="<portlet:namespace/>ips1" name="<portlet:namespace/>ips1" />.
		<input style="padding:4px;" maxlength="3" size="3" min="1" max="3"id="<portlet:namespace/>ips2" name="<portlet:namespace/>ips2" />.
		<input style="padding:4px;" maxlength="3" size="3" min="1" max="3"id="<portlet:namespace/>ips3" name="<portlet:namespace/>ips3" />.
		<input style="padding:4px;" maxlength="3" size="3" min="1" max="3"id="<portlet:namespace/>ips4" name="<portlet:namespace/>ips4" />
		<div id="<portlet:namespace/>error"></div>
		<liferay-ui:icon id="addIp"  image="add" url="#" message="add-ip-help" ><liferay-ui:message key="add-ip"/></liferay-ui:icon>
	</aui:fieldset>
	<aui:fieldset helpMessage="roles-fieldset-help" label="Roles" >
		<aui:select name="roles" multiple="true" label="">
		<%
			for (Role role : roles) {
				String selected = "";
				if (data != null) {
					if (ArrayUtil.contains(data.getRolesAsArray(), role.getRoleId())) {
						selected = "selected='selected'";
					}
				}
		%>
			<option <%=selected %> value="<%=role.getRoleId() %>"><%= role.getName()%></option>
		<%
			}
		%>
		</aui:select>
		
	</aui:fieldset>
	
	<aui:fieldset helpMessage="misc-fieldset-help" label="Misc">
		<aui:input type="checkbox" name="active" value="<%=data!=null?data.isActive():true %>"/>
		<%--
		<aui:input type="textarea" name="notes" style="width:360px;height:150px;"  />
		 --%>
		<aui:field-wrapper label="description">
			<liferay-ui:input-editor name="notes"
				toolbarSet="liferay-article" initMethod="initEditor" width="200" />
			<script type="text/javascript">
        		function <portlet:namespace />initEditor() { return "<%= UnicodeFormatter.toString(data!=null?data.getNotes():"") %>";
				}
			</script>
		</aui:field-wrapper>
	</aui:fieldset>
	
	<aui:button-row>
		<aui:button type="submit" />
	</aui:button-row>
</aui:form>

<script>
AUI().ready('aui-form-validator', 'aui-overlay-context-panel', function(A) {
	A.mix(
	        YUI.AUI.defaults.FormValidator.RULES,
	        {
	            selectRule: function(val, fieldNode, ruleValue) {

	                return val;

	            }
	        },
	        true
	);

	var validator1 = new A.FormValidator({
		boundingBox: document.<portlet:namespace/>fm,
		rules: {        
            <portlet:namespace />ipAddresses:{
                required: true,
                selectRule:true
            },
            <portlet:namespace />roles:{
                required: true,
                selectRule:true
            }
        },
		on: {
			submitError: function(event) {
				var formEvent = event.validator.formEvent;
				var errors = event.validator.errors;
			},
		 
			submit: function(event) {
				var formEvent = event.validator.formEvent;
			}
		}
	});
});

AUI().use('get', function(A){     
	A.Get.script('<%=request.getContextPath()%>/js/jquery-1.10.0.min.js', {
		onSuccess: function(){
			A.Get.script('<%=request.getContextPath()%>/js/jquery.quicksearch.js', {
				   onSuccess: function(){
						A.Get.script('<%=request.getContextPath()%>/js/jquery.multi-select.js', {
						   onSuccess: function(){
							   A.Get.script('<%=request.getContextPath()%>/js/jquery.autotab-1.1b.js', {
								   onSuccess: function(){
							   
								        $(document).ready(function() {
								        	$("#<portlet:namespace/>roles").multiSelect({
								        		selectableHeader: "<div class='custom-header selectable'><liferay-ui:message key='selectable-roles'/></div>",
								        		selectionHeader: "<div class='custom-header selected'><liferay-ui:message key='selected-roles'/></div>",
								        	});
								        	$("#<portlet:namespace/>ipAddresses").multiSelect({
								        		selectableHeader: "<div class='custom-header selectable'><liferay-ui:message key='selectable-ips'/></div>",
								        		selectionHeader: "<div class='custom-header selected'><liferay-ui:message key='selected-ips'/></div>",
								        	});
								        	$("#<portlet:namespace/>addIp").click(function(){
								        		$("#<portlet:namespace/>error").text("");
								        		var ip1 = $("#<portlet:namespace/>ips1").val();
								        		var ip2 = $("#<portlet:namespace/>ips2").val();
								        		var ip3 = $("#<portlet:namespace/>ips3").val();
								        		var ip4 = $("#<portlet:namespace/>ips4").val();
								        		var ip = ip1 + "." + ip2;
								        		if (ip3 != "") {
								        			ip += "." + ip3;
								        		}
								        		if (ip4 != "") {
								        			ip += "." + ip4;
								        		}
								        		if (validateIPaddress(ip1, false) && validateIPaddress(ip2, false) && validateIPaddress(ip3, true) && validateIPaddress(ip4, true)) {
								        			var found = false;
								        			$("#<portlet:namespace/>ipAddresses option").each(function(){
								        				if ($(this).val() === ip) {
								        					found = true;
								        					return;
								        				}
								        			});
								        			if (found) {
								        				$("#<portlet:namespace/>error").append('<liferay-ui:message key="ip-exists-already"/>');
								        			}
								        			else {
										        		$('#<portlet:namespace/>ipAddresses').append($('<option></option>').attr('value', ip).attr('selected', 'selected').text(ip));
										        		$("#<portlet:namespace/>ipAddresses").multiSelect('refresh');
								        			}
								        		}
								        		else {
								        			$("#<portlet:namespace/>error").append('<liferay-ui:message key="not-valid-ip"/>');
								        		}
								        	});
								        	$("#<portlet:namespace/>ips1,#<portlet:namespace/>ips2,#<portlet:namespace/>ips3,#<portlet:namespace/>ips4").autotab_magic().autotab_filter({
								        		format: 'numeric',
								        		nospace: true
								        	});
								        });
								   }
								}); 
						   }
						}); 
				   }
			}); 
		}
	}); 
});

function validateIPaddress(ipaddress, allowEmpty) {
	if (allowEmpty && ipaddress ==="") {
		return true;
	}
	
	if (/^(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$/
			.test(ipaddress)) {
		return (true);
	}
	return (false);
}
</script>