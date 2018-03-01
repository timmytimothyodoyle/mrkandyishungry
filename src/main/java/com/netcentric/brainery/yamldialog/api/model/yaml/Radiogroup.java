package com.netcentric.brainery.yamldialog.api.model.yaml;

import java.util.List;

import com.netcentric.brainery.yamldialog.api.model.AnnotationItem;
import com.netcentric.brainery.yamldialog.api.model.AnnotationType;
import com.netcentric.brainery.yamldialog.api.model.annotation.Optional;
import com.netcentric.brainery.yamldialog.api.model.annotation.Required;

public class Radiogroup extends AnnotationItem {

	@Required
	public String name;
	@Required
	public String title;
	@Optional
	public String orientation = "coral-RadioGroup--horizontal";
	@Optional
	public String description;
	@Optional
	public List<Radio> items;
	
	public Radiogroup() {
		super(AnnotationType.RADIOGROUP);
	}
}