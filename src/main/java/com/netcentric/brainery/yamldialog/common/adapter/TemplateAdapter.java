package com.netcentric.brainery.yamldialog.common.adapter;

import com.netcentric.brainery.yamldialog.api.adapter.AnyExportItemAdapter;
import com.netcentric.brainery.yamldialog.api.model.AnnotationItem;
import com.netcentric.brainery.yamldialog.api.model.DialogType;
import com.netcentric.brainery.yamldialog.api.model.TemplateItem;
import com.netcentric.brainery.yamldialog.common.TemplateItemProvider;
import com.netcentric.brainery.yamldialog.common.model.AnyExportItem;
import com.netcentric.brainery.yamldialog.common.model.NullAnyItem;

public abstract class TemplateAdapter<E extends AnnotationItem> implements AnyExportItemAdapter<E> {

	@Override
	public AnyExportItem adapt(E param, DialogType type) {
		TemplateItem template = TemplateItemProvider.get(type, param.getType());
		if (template.isValid()) {
			if (param.isValid()) {
				applyDefault(param, template);
				return apply(param, template);
			}
			// TODO error notification
			System.out.println("[CHECK] param invalid: " + param);
		}
		return new NullAnyItem();
	}

	private void applyDefault(E item, TemplateItem template) {
		template.setBooleanValue("required", item.required);
		template.setBooleanValue("disabled", item.disabled);
	}
	
	@Override
	public boolean isValid() {
		return true;
	}

	protected abstract AnyExportItem apply(E item, TemplateItem template);
}
