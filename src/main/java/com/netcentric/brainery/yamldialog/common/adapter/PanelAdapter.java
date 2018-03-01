package com.netcentric.brainery.yamldialog.common.adapter;

import static com.netcentric.brainery.yamldialog.common.factory.ItemAdapterFactory.make;

import com.netcentric.brainery.yamldialog.api.model.Item;
import com.netcentric.brainery.yamldialog.api.model.TemplateItem;
import com.netcentric.brainery.yamldialog.api.model.yaml.Panel;
import com.netcentric.brainery.yamldialog.common.model.AnyExportItem;
import com.netcentric.brainery.yamldialog.common.model.AnyExportItems;

public class PanelAdapter extends TemplateAdapter<Panel> {

	@Override
	protected AnyExportItem apply(Panel panel, TemplateItem template) {
		AnyExportItems items = new AnyExportItems();
		for (Item item : panel.items) {
			items.add(make(item).adapt(item, template.getKey().getType()));
		}
		template.setValue("name", panel.name);
		template.setValue("title", panel.title);
		template.setValue("items", items.toString());
		return new AnyExportItem(template.instanciate(), template.getKey());
	}

}
