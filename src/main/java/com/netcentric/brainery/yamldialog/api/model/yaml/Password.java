package com.netcentric.brainery.yamldialog.api.model.yaml;

import com.netcentric.brainery.yamldialog.api.model.AnnotationItem;
import com.netcentric.brainery.yamldialog.api.model.AnnotationType;
import com.netcentric.brainery.yamldialog.api.model.annotation.Optional;
import com.netcentric.brainery.yamldialog.api.model.annotation.Required;

public class Password extends AnnotationItem {

	@Required
	public String name;
	@Required
	public String title;
	@Optional
	public String empty;
	@Optional
	public String validation;
	@Optional
	public String description;
	
	public Password() {
		super(AnnotationType.PASSWORD);
	}
}