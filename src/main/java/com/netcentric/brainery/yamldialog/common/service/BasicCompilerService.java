package com.netcentric.brainery.yamldialog.common.service;

import java.io.IOException;

import com.netcentric.brainery.yamldialog.api.model.DialogType;
import com.netcentric.brainery.yamldialog.api.model.ExportItem;
import com.netcentric.brainery.yamldialog.api.model.NullAnyExporterItem;
import com.netcentric.brainery.yamldialog.api.model.yaml.Dialog;
import com.netcentric.brainery.yamldialog.api.service.CompilerService;
import com.netcentric.brainery.yamldialog.api.validation.model.Conflict;
import com.netcentric.brainery.yamldialog.api.validation.model.Conflicts;
import com.netcentric.brainery.yamldialog.common.adapter.DialogAdapter;
import com.netcentric.brainery.yamldialog.common.adapter.EditConfigAdapter;
import com.netcentric.brainery.yamldialog.common.model.AnyExportItem;
import com.netcentric.brainery.yamldialog.common.service.adapter.BasicYamlAdapter;
import com.netcentric.brainery.yamldialog.common.service.builer.AnyProjectItemBuilder;
import com.netcentric.brainery.yamldialog.common.validation.DialogValidation;
import com.netcentric.brainery.yamldialog.utils.IOUtils;

public class BasicCompilerService implements CompilerService {

	private DialogAdapter dialogAdapter = new DialogAdapter();

	private BasicYamlAdapter yamlAdapter = new BasicYamlAdapter();

	private DialogValidation dialogValidation = new DialogValidation();

	private EditConfigAdapter editConfigAdapter = new EditConfigAdapter();

	@Override
	public ExportItem build(String yamlcode, DialogType type) {
		// adapt @yamlcode to a YAML Dialog representation
		Dialog dialog = yamlAdapter.adapt(yamlcode);
		if (dialog.isValid()) {
			// adapt YAML dialog to a @type dialog representation
			AnyExportItem item = dialogAdapter.adapt(dialog, type);
			// adapt YAML dialog to a EditConfig dialog representation
			AnyExportItem ecItem = editConfigAdapter.adapt(dialog, type);
			// get the compile conflicts of the YAML dialog
			Conflicts conflicts = dialogValidation.validate(dialog);
			// return item only if is valid
			return new AnyProjectItemBuilder().dialog(item).editconfig(ecItem).content(new NullAnyExporterItem())
					.conflicts(conflicts).build();
		} else {
			System.out.println("powqieoiqwueqoiwueqoiwueqiuyeiquwye");
		}
		return new NullAnyExporterItem();
	}

	@Override
	public Conflicts compile(String yamlcode, DialogType type) {
		// adapt @yamlcode to a YAML Dialog representation
		Dialog dialog = yamlAdapter.adapt(yamlcode);
		if (dialog.isValid()) {
			return dialogValidation.validate(dialog);
		}
		return new Conflicts();
	}

	public static void main(String[] args) {
		try {
			Conflicts conflicts = new BasicCompilerService().compile(
					IOUtils.read("/Users/sebastianvenere/Documents/poc-simple-dialog.yaml"), DialogType.CLASSICUI);
			for (Conflict conflict : conflicts.list()) {
				System.out.println(conflict);
			}
			ExportItem result = new BasicCompilerService().build(
					IOUtils.read("/Users/sebastianvenere/Documents/poc-simple-dialog.yaml"), DialogType.CLASSICUI);
			System.out.println(result);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
