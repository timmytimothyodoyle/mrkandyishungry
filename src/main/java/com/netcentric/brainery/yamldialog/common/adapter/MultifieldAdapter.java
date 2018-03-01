package com.netcentric.brainery.yamldialog.common.adapter;

import static com.netcentric.brainery.yamldialog.common.factory.ItemAdapterFactory.make;

import com.netcentric.brainery.yamldialog.api.adapter.AnyExportItemAdapter;
import com.netcentric.brainery.yamldialog.api.model.Item;
import com.netcentric.brainery.yamldialog.api.model.TemplateItem;
import com.netcentric.brainery.yamldialog.api.model.yaml.Multifield;
import com.netcentric.brainery.yamldialog.common.model.AnyExportItem;
import com.netcentric.brainery.yamldialog.common.model.AnyExportItems;

public class MultifieldAdapter extends TemplateAdapter<Multifield> {

	@Override
	protected AnyExportItem apply(Multifield multifield, TemplateItem template) {
		AnyExportItems items = new AnyExportItems();
		for (Item item : multifield.items) {
			AnyExportItemAdapter<Item> adapter = make(item);
			if (adapter.isValid()) {
				items.add(adapter.adapt(item, template.getKey().getType()));
			} else {
				System.out.println("askjdhaksjhd asdkjashd aksdha kdhakjsdha sjdha dahsd");
			}
		}
		template.setValue("name", multifield.name);
		template.setValue("title", multifield.title);
		template.setValue("items", items.toString());
		template.setValue("description", multifield.description);
		return new AnyExportItem(template.instanciate(), template.getKey());
	}

}
