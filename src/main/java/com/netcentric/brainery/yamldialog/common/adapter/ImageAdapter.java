package com.netcentric.brainery.yamldialog.common.adapter;

import com.netcentric.brainery.yamldialog.api.model.TemplateItem;
import com.netcentric.brainery.yamldialog.api.model.yaml.Image;
import com.netcentric.brainery.yamldialog.common.model.AnyExportItem;

public class ImageAdapter extends TemplateAdapter<Image> {

	@Override
	protected AnyExportItem apply(Image image, TemplateItem template) {
		template.setValue("name", image.name);
		template.setValue("mime", image.mime);
		template.setValue("title", image.title);
		template.setValue("empty", image.empty);
		template.setValue("validation", image.validation);
		template.setValue("description", image.description);
		template.setNumericValue("size", image.size);
		template.setBooleanValue("async", image.async);
		template.setBooleanValue("multiple", image.multiple);
		return new AnyExportItem(template.instanciate(), template.getKey());
	}

}
