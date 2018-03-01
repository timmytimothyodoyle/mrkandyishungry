package com.netcentric.brainery.yamldialog.common.adapter;

import com.netcentric.brainery.yamldialog.api.model.TemplateItem;
import com.netcentric.brainery.yamldialog.api.model.yaml.Numberfield;
import com.netcentric.brainery.yamldialog.common.model.AnyExportItem;

public class NumberfieldAdapter extends TemplateAdapter<Numberfield> {

	@Override
	protected AnyExportItem apply(Numberfield numberfield, TemplateItem template) {
		template.setValue("name", numberfield.name);
		template.setValue("title", numberfield.title);
		template.setValue("max", numberfield.max);
		template.setValue("min", numberfield.min);
		template.setValue("step", numberfield.step);
		template.setValue("value", numberfield.value);
		template.setValue("description", numberfield.description);
		return new AnyExportItem(template.instanciate(), template.getKey());
	}

}
