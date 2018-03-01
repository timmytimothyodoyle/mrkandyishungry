package com.netcentric.brainery.yamldialog.common.adapter;

import com.netcentric.brainery.yamldialog.api.model.TemplateItem;
import com.netcentric.brainery.yamldialog.api.model.yaml.Radio;
import com.netcentric.brainery.yamldialog.common.model.AnyExportItem;

public class RadioAdapter extends TemplateAdapter<Radio> {

	@Override
	protected AnyExportItem apply(Radio radio, TemplateItem template) {
		template.setValue("text", radio.text);
		template.setValue("value", radio.value);
		template.setBooleanValue("checked", radio.checked);
		template.setNumericValue("id", radio.id);
		return new AnyExportItem(template.instanciate(), template.getKey());
	}

}