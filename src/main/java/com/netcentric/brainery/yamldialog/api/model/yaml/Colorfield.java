package com.netcentric.brainery.yamldialog.api.model.yaml;

import com.netcentric.brainery.yamldialog.api.model.AnnotationItem;
import com.netcentric.brainery.yamldialog.api.model.AnnotationType;
import com.netcentric.brainery.yamldialog.api.model.annotation.Optional;
import com.netcentric.brainery.yamldialog.api.model.annotation.Required;

public class Colorfield extends AnnotationItem {

	@Required
	public String name;
	@Required
	public String title;
	@Optional
	public String value;
	@Optional
	public String validation;
	@Optional
	public String description;
	
	public Colorfield() {
		super(AnnotationType.COLORFIELD);
	}
}
