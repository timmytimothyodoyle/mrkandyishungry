package com.netcentric.brainery.yamldialog.common.adapter;

import com.netcentric.brainery.yamldialog.api.model.TemplateItem;
import com.netcentric.brainery.yamldialog.api.model.yaml.Colorfield;
import com.netcentric.brainery.yamldialog.common.model.AnyExportItem;

public class ColorfieldAdapter extends TemplateAdapter<Colorfield> {

	@Override
	protected AnyExportItem apply(Colorfield colorfield, TemplateItem template) {
		template.setValue("name", colorfield.name);
		template.setValue("title", colorfield.title);
		template.setValue("value", colorfield.value);
		template.setValue("validation", colorfield.validation);
		template.setValue("description", colorfield.description);
		return new AnyExportItem(template.instanciate(), template.getKey());
	}

}
