package com.netcentric.brainery.yamldialog.common.adapter;

import static com.netcentric.brainery.yamldialog.common.factory.EditConfigBuilderFactory.make;

import com.netcentric.brainery.yamldialog.api.adapter.AnyExportItemAdapter;
import com.netcentric.brainery.yamldialog.api.model.AnnotationItem;
import com.netcentric.brainery.yamldialog.api.model.DialogType;
import com.netcentric.brainery.yamldialog.api.model.NullAnyExporterItem;
import com.netcentric.brainery.yamldialog.api.model.yaml.Dialog;
import com.netcentric.brainery.yamldialog.api.model.yaml.Image;
import com.netcentric.brainery.yamldialog.api.model.yaml.Panel;
import com.netcentric.brainery.yamldialog.common.editconfig.EditConfigBuilder;
import com.netcentric.brainery.yamldialog.common.model.AnyExportItem;

public class EditConfigAdapter implements AnyExportItemAdapter<Dialog> {

	@Override
	public AnyExportItem adapt(Dialog dialog, DialogType type) {
		if (!dialog.isValid()) {
			return new NullAnyExporterItem();
		}
		EditConfigBuilder builder = make(type);
		for (Panel panel : dialog.items) {
			if (panel.isValid()) {
				for (AnnotationItem item : panel.items) {
					if (item instanceof Image) {
						builder.dropTarget((Image) item);
					}
				}
			}
		}
		return builder.build();
	}

	@Override
	public boolean isValid() {
		return true;
	}

}