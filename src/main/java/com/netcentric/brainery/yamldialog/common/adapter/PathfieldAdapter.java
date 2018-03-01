package com.netcentric.brainery.yamldialog.common.adapter;

import com.netcentric.brainery.yamldialog.api.model.TemplateItem;
import com.netcentric.brainery.yamldialog.api.model.yaml.Pathfield;
import com.netcentric.brainery.yamldialog.common.model.AnyExportItem;

public class PathfieldAdapter extends TemplateAdapter<Pathfield> {

	@Override
	protected AnyExportItem apply(Pathfield pathfield, TemplateItem template) {
		template.setValue("name", pathfield.name);
		template.setValue("root", pathfield.root);
		template.setValue("title", pathfield.title);
		template.setValue("empty", pathfield.empty);
		template.setValue("validation", pathfield.validation);
		template.setValue("description", pathfield.description);
		template.setValue("defaultvalue", pathfield.defaultvalue);
		return new AnyExportItem(template.instanciate(), template.getKey());
	}

}