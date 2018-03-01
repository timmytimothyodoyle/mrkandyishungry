package com.netcentric.brainery.yamldialog.common.adapter;

import com.netcentric.brainery.yamldialog.api.model.TemplateItem;
import com.netcentric.brainery.yamldialog.api.model.yaml.Checkbox;
import com.netcentric.brainery.yamldialog.common.model.AnyExportItem;

public class CheckboxAdapter extends TemplateAdapter<Checkbox> {

	@Override
	protected AnyExportItem apply(Checkbox checkbox, TemplateItem template) {
		template.setValue("name", checkbox.name);
		template.setValue("title", checkbox.title);
		template.setValue("value", checkbox.checked);
		template.setValue("unchecked", checkbox.unchecked);
		template.setValue("description", checkbox.description);
		template.setBooleanValue("checked", checkbox.defaultvalue);
		template.setBooleanValue("autosubmit", checkbox.autosubmit);
		template.setBooleanValue("defaultvalue", checkbox.defaultvalue);
		return new AnyExportItem(template.instanciate(), template.getKey());
	}

}
