package com.netcentric.brainery.yamldialog.common.adapter;

import com.netcentric.brainery.yamldialog.api.model.TemplateItem;
import com.netcentric.brainery.yamldialog.api.model.yaml.Textfield;
import com.netcentric.brainery.yamldialog.common.model.AnyExportItem;

public class TextfieldAdapter extends TemplateAdapter<Textfield> {

	@Override
	protected AnyExportItem apply(Textfield textfield, TemplateItem template) {
		template.setValue("name", textfield.name);
		template.setValue("title", textfield.title);
		template.setValue("empty", textfield.empty);
		template.setValue("maxlength", textfield.maxlength);
		template.setValue("validation", textfield.validation);
		template.setValue("description", textfield.description);
		return new AnyExportItem(template.instanciate(), template.getKey());
	}

}
