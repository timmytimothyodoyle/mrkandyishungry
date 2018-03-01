package com.netcentric.brainery.yamldialog.platform.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonObject;
import com.netcentric.brainery.yamldialog.api.model.DialogType;
import com.netcentric.brainery.yamldialog.common.model.AnyProjectItem;
import com.netcentric.brainery.yamldialog.common.service.BasicCompilerService;
import com.netcentric.brainery.yamldialog.platform.web.ace.AceCode;
import com.netcentric.brainery.yamldialog.platform.web.ace.AceConflicts;
import com.netcentric.brainery.yamldialog.platform.web.ace.AceOutput;
import com.netcentric.brainery.yamldialog.platform.web.ace.adapter.AceOutputJsonAdapter;
import com.netcentric.brainery.yamldialog.platform.web.ace.adapter.ConflictsAceConflictsAdapter;
import com.netcentric.brainery.yamldialog.platform.web.ace.builder.AceOutputBuilder;

@WebServlet("/export")
public class AjaxYamlExporterServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private AceOutputJsonAdapter outputAdapter;

	private AceOutputBuilder outputBuilder;

	private BasicCompilerService compilerService;

	public AjaxYamlExporterServlet() {
		outputBuilder = new AceOutputBuilder();
		outputAdapter = new AceOutputJsonAdapter();
		compilerService = new BasicCompilerService();
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		AnyProjectItem project = (AnyProjectItem) compilerService.build(request.getParameter("yamlcode"),
				DialogType.TOUCHUI_CORAL);
		if (project.isValid()) {
			// create output representations
			AceCode aceCode = new AceCode(project.getDialog().getItem(), "touchui", "xml");

			AceCode aceEditConfig = new AceCode(project.getEditConfig().getItem(), "touchui", "xml");

			AceConflicts aceConflicts = new ConflictsAceConflictsAdapter().adapt(project.getConflitcs());
			//
			AceOutput output = outputBuilder.code(aceCode).editConfing(aceEditConfig).conflicts(aceConflicts).build();
			//
			JsonObject responseOutput = outputAdapter.adapt(output);
			//
			response.setStatus(HttpServletResponse.SC_ACCEPTED);
			response.getWriter().write(responseOutput.toString());
		} else {
			System.out.println("INVALID PROJECT, to many things went wrong, your welcome");
		}
	}
}
