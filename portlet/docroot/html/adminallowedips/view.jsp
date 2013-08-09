<%@ include file="/html/init.jsp" %>

<liferay-portlet:renderURL var="portletURL"/>

<%
	String showItem = ParamUtil.getString(request, "showItem", "1");
%>

<liferay-ui:tabs
     names="showDataButton,showConfigurationButton"
     tabsValues="1,2"
     param="showItem"
     url="<%= portletURL %>"
/>

<%
	if (showItem.equals("1")) {
%>
<%@ include file="/html/adminallowedips/data.jsp"%>
<%
	}
	else if (showItem.equals("2")) {
%>
<%@ include file="/html/adminallowedips/ipsConfiguration.jsp"%>
<%
	}
%>