package com.netcentric.brainery.yamldialog.platform.web.adapter;

import javax.servlet.http.HttpServletRequest;

import com.netcentric.brainery.yamldialog.api.adapter.AnyAdapter;
import com.netcentric.brainery.yamldialog.common.model.YdbProject;

public class HtmlRequestYdbProjectAdapter implements AnyAdapter<YdbProject, HttpServletRequest> {

	@Override
	public YdbProject adapt(HttpServletRequest request) {
		String code = request.getParameter("yamlcode");
		String destination = request.getParameter("destination");
		return new YdbProject(code, destination);
	}

}
