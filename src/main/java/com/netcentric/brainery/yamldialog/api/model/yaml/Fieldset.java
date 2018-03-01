package com.netcentric.brainery.yamldialog.api.model.yaml;

import java.util.List;

import com.netcentric.brainery.yamldialog.api.model.AnnotationItem;
import com.netcentric.brainery.yamldialog.api.model.AnnotationType;
import com.netcentric.brainery.yamldialog.api.model.annotation.Required;
import com.netcentric.brainery.yamldialog.utils.Utils;

public class Fieldset extends AnnotationItem {

	@Required
	public String title;
	@Required
	public String name = Utils.randomize("fieldset");
	@Required
	public List<AnnotationItem> items;
	
	public Fieldset() {
		super(AnnotationType.FIELDSET);
	}
}