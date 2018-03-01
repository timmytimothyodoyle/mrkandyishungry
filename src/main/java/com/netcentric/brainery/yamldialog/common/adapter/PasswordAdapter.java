package com.netcentric.brainery.yamldialog.common.adapter;

import com.netcentric.brainery.yamldialog.api.model.TemplateItem;
import com.netcentric.brainery.yamldialog.api.model.yaml.Password;
import com.netcentric.brainery.yamldialog.common.model.AnyExportItem;

public class PasswordAdapter extends TemplateAdapter<Password> {

	@Override
	protected AnyExportItem apply(Password password, TemplateItem template) {
		template.setValue("name", password.name);
		template.setValue("empty", password.empty);
		template.setValue("title", password.title);
		template.setValue("validation", password.validation);
		template.setValue("description", password.description);
		return new AnyExportItem(template.instanciate(), template.getKey());
	}

}