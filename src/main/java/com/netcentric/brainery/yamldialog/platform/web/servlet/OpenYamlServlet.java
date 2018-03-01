package com.netcentric.brainery.yamldialog.platform.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonObject;
import com.netcentric.brainery.yamldialog.platform.web.adapter.open.YamlYdbProjectJSONAdapter;

@WebServlet("/openyaml")
public class OpenYamlServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// request adapter
		String content = request.getParameter("content");

		try {
			JsonObject projectJson = new YamlYdbProjectJSONAdapter().adapt(content);
			response.setStatus(HttpServletResponse.SC_ACCEPTED);
			response.getWriter().write(projectJson.toString());
		} catch (Exception e) {
			e.printStackTrace();
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		}
	}
}