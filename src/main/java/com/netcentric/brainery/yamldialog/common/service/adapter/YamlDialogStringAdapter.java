package com.netcentric.brainery.yamldialog.common.service.adapter;

import com.esotericsoftware.yamlbeans.YamlException;
import com.esotericsoftware.yamlbeans.YamlReader;
import com.netcentric.brainery.yamldialog.api.adapter.AnyAdapter;
import com.netcentric.brainery.yamldialog.api.model.yaml.Dialog;
import com.netcentric.brainery.yamldialog.api.model.yaml.NullDialog;
import com.netcentric.brainery.yamldialog.api.validation.model.Conflict;
import com.netcentric.brainery.yamldialog.api.validation.model.Severity;
import com.netcentric.brainery.yamldialog.utils.ModelUtils;

public class YamlDialogStringAdapter implements AnyAdapter<Dialog, String> {

	public Dialog adapt(String code) {
		Dialog dialog;
		// initialize YamlReader and configure with model map
		YamlReader reader = new YamlReader(code);
		for (String key : ModelUtils.modelClassMap.keySet()) {
			reader.getConfig().setClassTag(key, ModelUtils.modelClassMap.get(key));
		}
		// read the dialog, it will work only if the code is properly formated
		try {
			dialog = reader.read(Dialog.class);
		} catch (YamlException e) {
			dialog = new NullDialog();
			dialog.conflict(
					new Conflict(Severity.SEVERE, "YAML code is not nazi formated, error: " + e.getMessage(), dialog));

		}
		return dialog;
	}
}