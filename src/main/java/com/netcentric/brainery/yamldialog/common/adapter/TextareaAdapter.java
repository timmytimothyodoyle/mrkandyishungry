package com.netcentric.brainery.yamldialog.common.adapter;

import com.netcentric.brainery.yamldialog.api.model.TemplateItem;
import com.netcentric.brainery.yamldialog.api.model.yaml.TextArea;
import com.netcentric.brainery.yamldialog.common.model.AnyExportItem;

public class TextareaAdapter extends TemplateAdapter<TextArea> {

	@Override
	protected AnyExportItem apply(TextArea textarea, TemplateItem template) {
		template.setValue("name", textarea.name);
		template.setValue("rows", textarea.rows);
		template.setValue("empty", textarea.empty);
		template.setValue("title", textarea.title);
		template.setValue("value", textarea.value);
		template.setValue("columns", textarea.columns);
		template.setValue("maxlength", textarea.maxlength);
		template.setValue("description", textarea.description);
		return new AnyExportItem(template.instanciate(), template.getKey());
	}

}