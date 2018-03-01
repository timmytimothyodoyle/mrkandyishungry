package com.netcentric.brainery.yamldialog.common.adapter;

import com.netcentric.brainery.yamldialog.api.model.TemplateItem;
import com.netcentric.brainery.yamldialog.api.model.yaml.Switch;
import com.netcentric.brainery.yamldialog.common.model.AnyExportItem;

public class SwitchAdapter extends TemplateAdapter<Switch> {

	@Override
	protected AnyExportItem apply(Switch item, TemplateItem template) {
		template.setValue("on", item.on);
		template.setValue("off", item.off);
		template.setValue("name", item.name);
		template.setValue("title", item.title);
		template.setValue("clazz", item.clazz);
		template.setValue("checked", item.checked);
		template.setValue("unchecked", item.unchecked);
		template.setValue("description", item.description);
		template.setBooleanValue("defaultvalue", item.defaultvalue);
		return new AnyExportItem(template.instanciate(), template.getKey());
	}

}