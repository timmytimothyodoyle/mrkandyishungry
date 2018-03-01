package com.netcentric.brainery.yamldialog.platform.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.netcentric.brainery.yamldialog.common.model.YdbProject;
import com.netcentric.brainery.yamldialog.platform.web.adapter.HtmlRequestYdbProjectAdapter;
import com.netcentric.brainery.yamldialog.utils.IOUtils;

@WebServlet("/saveyaml")
public class SaveYamlServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private HtmlRequestYdbProjectAdapter projectAdapter;

	public SaveYamlServlet() {
		projectAdapter = new HtmlRequestYdbProjectAdapter();
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// adapt the request to a YDB project
		YdbProject project = projectAdapter.adapt(request);
		//
		if (project.isValid()) {
			if (IOUtils.save(project.getDestination(), project.getCode())) {
				response.setStatus(HttpServletResponse.SC_ACCEPTED);
				return;
			} else {
				response.getWriter().write("can't save to file " + project.getDestination());
			}
		} else {
			response.getWriter().write("destination is missing little unicornn.");
		}
		response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
	}

}