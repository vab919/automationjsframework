package com.kp.fof.productzero.core.servlets;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;

import org.apache.felix.scr.annotations.sling.SlingServlet;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;

@SlingServlet(label = "FFL - Service Servlet", metatype = true, methods = {
		"POST" }, name = "com.kp.fof.productzero.core.servlets.FFLPostServlet", paths = { "/services/processFormData" })
public class FFLPostServlet extends SlingAllMethodsServlet {

	/**
		 * 
		 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(SlingHttpServletRequest request, SlingHttpServletResponse response)
			throws ServletException, IOException {

		String paramName;
		String paramValue;
		String currentPagePath = "";
		String zipCode = "";
		String facilityRegionCode = "";

		try {
			Enumeration<String> parameterNames = request.getParameterNames();
			Map<String, String> formParametersMap = new HashMap<String, String>();
			while (parameterNames.hasMoreElements()) {
				paramName = parameterNames.nextElement();
				paramValue = request.getParameter(paramName);

				if (paramName.equals(":redirect")) {
					currentPagePath = paramValue;
				} else if (paramName.equals("zipCode")) {
					zipCode = paramValue;
				} else if (paramName.equals("facilityRegionCode")) {
					facilityRegionCode = paramValue;
				} else {
					formParametersMap.put(paramName, paramValue);
				}
			}
			request.setAttribute("zipCode", zipCode);
			request.setAttribute("facilityRegionCode", facilityRegionCode);
			response.sendRedirect(currentPagePath + ".html?q=" + zipCode +"&m="+ facilityRegionCode);

		} catch (Exception e) {
			// log.error("SlingServlet Failed while retrieving resources");
		} finally {
			// TODO
		}
	}

	/**
	 * Wrapper class to always return GET for AEM to process the
	 * request/response as GET.
	 */
	/*
	 * private static class GetRequest extends SlingHttpServletRequestWrapper {
	 * public GetRequest(SlingHttpServletRequest wrappedRequest) {
	 * super(wrappedRequest); }
	 * 
	 * @Override public String getMethod() { return "GET"; } }
	 */
	protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response)
			throws ServletException, IOException {

	}
}