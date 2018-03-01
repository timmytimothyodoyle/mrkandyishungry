package com.netcentric.brainery.yamldialog.common.adapter;

import static com.netcentric.brainery.yamldialog.common.factory.ItemAdapterFactory.make;

import com.netcentric.brainery.yamldialog.api.adapter.AnyExportItemAdapter;
import com.netcentric.brainery.yamldialog.api.model.Item;
import com.netcentric.brainery.yamldialog.api.model.TemplateItem;
import com.netcentric.brainery.yamldialog.api.model.yaml.Fieldset;
import com.netcentric.brainery.yamldialog.common.model.AnyExportItem;
import com.netcentric.brainery.yamldialog.common.model.AnyExportItems;

public class FieldsetAdapter extends TemplateAdapter<Fieldset> {

	@Override
	protected AnyExportItem apply(Fieldset fieldset, TemplateItem template) {
		AnyExportItems items = new AnyExportItems();
		for (Item item : fieldset.items) {
			AnyExportItemAdapter<Item> adapter = make(item);
			if(adapter.isValid()) {
				items.add(adapter.adapt(item, template.getKey().getType()));	
			} else {
				System.out.println("CA MASSSSSSS");
			}
		}
		template.setValue("name", fieldset.name);
		template.setValue("title", fieldset.title);
		template.setValue("items", items.toString());
		return new AnyExportItem(template.instanciate(), template.getKey());
	}

}
