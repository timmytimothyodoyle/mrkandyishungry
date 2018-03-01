package com.netcentric.brainery.yamldialog.common.service.adapter;

import com.netcentric.brainery.yamldialog.api.adapter.AnyAdapter;
import com.netcentric.brainery.yamldialog.api.model.yaml.Dialog;

public class BasicYamlAdapter implements AnyAdapter<Dialog, String> {

	private YamlFormatStringAdapter formatAdapter;

	private YamlDialogStringAdapter dialogAdapter;

	public BasicYamlAdapter() {
		formatAdapter = new YamlFormatStringAdapter();
		dialogAdapter = new YamlDialogStringAdapter();
	}

	@Override
	public Dialog adapt(String yamlcode) {
		return dialogAdapter.adapt(formatAdapter.adapt(yamlcode));
	}

}
