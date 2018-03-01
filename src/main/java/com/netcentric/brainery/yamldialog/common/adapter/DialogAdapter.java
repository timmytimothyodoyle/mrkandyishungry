package com.netcentric.brainery.yamldialog.common.adapter;

import com.netcentric.brainery.yamldialog.api.adapter.AnyExportItemAdapter;
import com.netcentric.brainery.yamldialog.api.model.AnnotationType;
import com.netcentric.brainery.yamldialog.api.model.DialogType;
import com.netcentric.brainery.yamldialog.api.model.TemplateItem;
import com.netcentric.brainery.yamldialog.api.model.yaml.Dialog;
import com.netcentric.brainery.yamldialog.api.model.yaml.Panel;
import com.netcentric.brainery.yamldialog.common.TemplateItemProvider;
import com.netcentric.brainery.yamldialog.common.model.AnyExportItem;
import com.netcentric.brainery.yamldialog.common.model.AnyExportItems;
import com.netcentric.brainery.yamldialog.common.model.NullAnyItem;

public class DialogAdapter implements AnyExportItemAdapter<Dialog> {

	private PanelAdapter adapter = new PanelAdapter();

	@Override
	public AnyExportItem adapt(Dialog dialog, DialogType type) {
		if (dialog.isValid()) {
			AnyExportItems items = new AnyExportItems();
			for (Panel item : dialog.items) {
				items.add(adapter.adapt(item, type));
			}
			TemplateItem template = TemplateItemProvider.get(type, getAnnotationType(items));
			template.setValue("title", dialog.title);
			template.setValue("items", items.toString());
			return new AnyExportItem(new PostProcessorAdapter().adapt(template.instanciate()), template.getKey());
		}
		return new NullAnyItem();
	}

	private AnnotationType getAnnotationType(AnyExportItems items) {
		return items.size() > 1 ? AnnotationType.DIALOG_MULTI : AnnotationType.DIALOG_SIMPLE;
	}

	@Override
	public boolean isValid() {
		return true;
	}

}