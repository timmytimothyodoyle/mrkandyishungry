package com.netcentric.brainery.yamldialog.api.model.yaml;

import com.netcentric.brainery.yamldialog.api.model.AnnotationItem;
import com.netcentric.brainery.yamldialog.api.model.AnnotationType;
import com.netcentric.brainery.yamldialog.api.model.annotation.Optional;
import com.netcentric.brainery.yamldialog.api.model.annotation.Required;

public class TextArea extends AnnotationItem {

	@Required
	public String name;
	@Required
	public String title;
	@Optional
	public String empty;
	@Optional
	public String rows;
	@Optional
	public String value;
	@Optional
	public String columns;
	@Optional
	public String maxlength;
	@Optional
	public String description;
	
	public TextArea() {
		super(AnnotationType.TEXTAREA);
	}
}
