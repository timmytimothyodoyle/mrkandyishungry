package com.netcentric.brainery.yamldialog.common.adapter;

import static com.netcentric.brainery.yamldialog.common.factory.ItemAdapterFactory.make;

import com.netcentric.brainery.yamldialog.api.model.TemplateItem;
import com.netcentric.brainery.yamldialog.api.model.yaml.Option;
import com.netcentric.brainery.yamldialog.api.model.yaml.Select;
import com.netcentric.brainery.yamldialog.common.model.AnyExportItem;
import com.netcentric.brainery.yamldialog.common.model.AnyExportItems;

public class SelectAdapter extends TemplateAdapter<Select> {

	@Override
	protected AnyExportItem apply(Select select, TemplateItem template) {
		template.setValue("name", select.name);
		template.setValue("title", select.title);
		template.setValue("empty", select.empty);
		template.setValue("target", select.target);
		template.setValue("validation", select.validation);
		template.setValue("description", select.description);
		template.setValue("defaultvalue", select.defaultvalue);
		template.setBooleanValue("ordered", select.ordered);
		template.setBooleanValue("multiple", select.multiple);
		template.setBooleanValue("translate", select.translate);

		int count = 0;
		AnyExportItems options = new AnyExportItems();
		for (Option option : select.items) {
			if (option.isValid()) {
				option.id = count++;
				if (option.value.equals(select.defaultvalue))
					option.selected = "true";
				options.add(make(option).adapt(option, template.getKey().getType()));
			}
		}
		template.setValue("options", options.toString());
		return new AnyExportItem(template.instanciate(), template.getKey());
	}

}