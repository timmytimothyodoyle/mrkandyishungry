package com.netcentric.brainery.yamldialog.common.adapter;

import static com.netcentric.brainery.yamldialog.common.factory.ItemAdapterFactory.make;
import static com.netcentric.brainery.yamldialog.utils.Utils.safe;

import com.netcentric.brainery.yamldialog.api.model.TemplateItem;
import com.netcentric.brainery.yamldialog.api.model.yaml.Radio;
import com.netcentric.brainery.yamldialog.api.model.yaml.Radiogroup;
import com.netcentric.brainery.yamldialog.common.model.AnyExportItem;
import com.netcentric.brainery.yamldialog.common.model.AnyExportItems;

public class RadiogroupAdapter extends TemplateAdapter<Radiogroup> {

	@Override
	protected AnyExportItem apply(Radiogroup radiogroup, TemplateItem template) {
		template.setValue("name", radiogroup.name);
		template.setValue("title", radiogroup.title);
		template.setValue("orientation", radiogroup.orientation);
		template.setValue("description", radiogroup.description);

		int count = 0;
		AnyExportItems radios = new AnyExportItems();
		for (Radio radio : safe(radiogroup.items, Radio.class)) {
			if (radio.isValid()) {
				radio.id = count++;
				radios.add(make(radio).adapt(radio, template.getKey().getType()));
			}
		}
		template.setValue("radios", radios.toString());
		return new AnyExportItem(template.instanciate(), template.getKey());
	}

}