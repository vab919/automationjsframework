<%@page session="false"%>
<%@include file="/libs/foundation/global.jsp"%>
<cq:includeClientLib categories="granite.csrf.standalone"/>
<%@ page import="com.kp.fof.productzero.core.models.*"%>
<%@ page import="com.kp.fof.productzero.core.fflxmlhelper.*"%>
<%@ page import="java.util.List"%>

<p><h2>Find the Facilities by Zip Code </h2></p>

<p>

<form method="POST" action="<%= currentNode.getPath()%>.html"> 

    <input type="text" id="facilityZipCode"  name="facilityZipCode" value="" class ="" style="width:180px;">

    <select id="facilityRegionCode" name="facilityRegionCode" class ="" style="width:180px;">
      <option value="GGA">GGA</option>
         <option value="NCA">NCA</option>
    </select> 
    <br>

    <input type="submit" value="Search" class="kpPageSearchButton" style="width:195px;height:30px;" id="findFacilityByLocation"/>

</form>

</p>

<%   
     if(request.getParameter("q")!=null){
     FFLServiceInterface fflService=new FFLService();
     List<FacilityType> zipCodeFacility =fflService.getFacilityDetails(request.getParameter("q"),request.getParameter("m"));
     if(zipCodeFacility.size()>0){
     for(FacilityType facility : zipCodeFacility) {  %>     <font class="bold-font" color="blue"> <%
         out.println(facility.getOfficialName()+"</b><br>"); %>  </font> <%
			out.println(facility.getAddress().toString()+"<br>");
			if(facility.getPhoneNumbers() != null && facility.getPhoneNumbers().getPhoneNumbers() != null){
				for(PhoneType phone : facility.getPhoneNumbers().getPhoneNumbers()){
					if("Local".equalsIgnoreCase(phone.getPhoneType())){
						out.println(phone.getFormattedPhNbr()+"<br>");		
					}
				}
			}
			out.println("<br><br>"); 
		}
		}
		if(zipCodeFacility.size()==0)
		{ %>
		     <div id="displayLocation">No Results found</div>
	<%	}		

     }
 %>
 
 <div id="displayLocations"></div>
