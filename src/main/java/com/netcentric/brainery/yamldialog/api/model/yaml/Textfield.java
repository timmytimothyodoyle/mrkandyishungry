package com.netcentric.brainery.yamldialog.api.model.yaml;

import com.netcentric.brainery.yamldialog.api.model.AnnotationItem;
import com.netcentric.brainery.yamldialog.api.model.AnnotationType;
import com.netcentric.brainery.yamldialog.api.model.annotation.Optional;
import com.netcentric.brainery.yamldialog.api.model.annotation.Required;

public class Textfield extends AnnotationItem {

	@Required
	public String name;
	@Required
	public String title;
	@Optional
	public String empty;
	@Optional
	public String maxlength;	
	@Optional
	public String validation;
	@Optional
	public String description;
	
	public Textfield() {
		super(AnnotationType.TEXTFIELD);
	}
}