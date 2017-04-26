<%@include file="/libs/foundation/global.jsp"%>

<%@page session="false" %>

<%

    //request.setAttribute("facilityZipCode", "You entered this search term:" + request.getParameter("facilityZipCode"));
	//request.setAttribute("facilityRegionCode", "You entered this search term:" + request.getParameter("facilityRegionCode"));
	// Adding parameter in query but, in your case you cad set it as request attribute and forward request.

    response.sendRedirect(currentPage.getPath() + ".html?q="+request.getParameter("facilityZipCode")+"&m="+request.getParameter("facilityRegionCode"));

%>
