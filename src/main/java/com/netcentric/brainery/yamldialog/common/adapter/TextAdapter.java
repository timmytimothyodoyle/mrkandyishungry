package com.netcentric.brainery.yamldialog.common.adapter;

import com.netcentric.brainery.yamldialog.api.model.TemplateItem;
import com.netcentric.brainery.yamldialog.api.model.yaml.Text;
import com.netcentric.brainery.yamldialog.common.model.AnyExportItem;

public class TextAdapter extends TemplateAdapter<Text> {

	@Override
	protected AnyExportItem apply(Text text, TemplateItem template) {
		template.setValue("name", text.name);
		template.setValue("text", text.text);
		return new AnyExportItem(template.instanciate(), template.getKey());
	}

}
