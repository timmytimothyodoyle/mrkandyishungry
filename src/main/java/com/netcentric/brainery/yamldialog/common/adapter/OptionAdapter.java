package com.netcentric.brainery.yamldialog.common.adapter;

import com.netcentric.brainery.yamldialog.api.model.TemplateItem;
import com.netcentric.brainery.yamldialog.api.model.yaml.Option;
import com.netcentric.brainery.yamldialog.common.model.AnyExportItem;

public class OptionAdapter extends TemplateAdapter<Option> {

	@Override
	protected AnyExportItem apply(Option option, TemplateItem template) {
		template.setValue("text", option.text);
		template.setValue("icon", option.icon);
		template.setValue("value", option.value);
		template.setValue("selected", option.selected);
		template.setNumericValue("id", option.id);
		return new AnyExportItem(template.instanciate(), template.getKey());
	}

}