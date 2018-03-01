package com.netcentric.brainery.yamldialog.platform.web.adapter;

import javax.servlet.http.HttpServletRequest;

import com.netcentric.brainery.yamldialog.api.adapter.AnyAdapter;
import com.netcentric.brainery.yamldialog.api.model.yaml.Dialog;
import com.netcentric.brainery.yamldialog.api.model.yaml.NullDialog;

public class HtmlRequestYamlAdapter implements AnyAdapter<Dialog, HttpServletRequest> {

	private YamlFormatStringAdapter yamlFormatAdapter;

	private YamlDialogStringAdapter yamlDialogAdapter;

	public HtmlRequestYamlAdapter() {
		yamlFormatAdapter = new YamlFormatStringAdapter();
		yamlDialogAdapter = new YamlDialogStringAdapter();
	}

	public Dialog adapt(HttpServletRequest request) {
		String yamlcode = request.getParameter("yamlcode");
		if (yamlcode != null) {
			return yamlDialogAdapter.adapt(yamlFormatAdapter.adapt(yamlcode));
		}
		return new NullDialog();
	}

}