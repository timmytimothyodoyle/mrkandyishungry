package com.netcentric.brainery.yamldialog.api.model.yaml;

import java.util.List;

import com.netcentric.brainery.yamldialog.api.model.AnnotationItem;
import com.netcentric.brainery.yamldialog.api.model.AnnotationType;
import com.netcentric.brainery.yamldialog.api.model.annotation.Optional;
import com.netcentric.brainery.yamldialog.api.model.annotation.Required;

public class Multifield extends AnnotationItem {

	@Required
	public String name;
	@Required
	public String title;
	@Optional
	public String description;
	@Required
	public List<AnnotationItem> items;
	
	public Multifield() {
		super(AnnotationType.MULTIFIELD);
	}
}
