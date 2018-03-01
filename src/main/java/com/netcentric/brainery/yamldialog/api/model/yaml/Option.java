package com.netcentric.brainery.yamldialog.api.model.yaml;

import com.netcentric.brainery.yamldialog.api.model.AnnotationItem;
import com.netcentric.brainery.yamldialog.api.model.AnnotationType;
import com.netcentric.brainery.yamldialog.api.model.annotation.Optional;
import com.netcentric.brainery.yamldialog.api.model.annotation.Required;

public class Option extends AnnotationItem {

	public int id;
	@Required
	public String text;
	@Required
	public String value;
	@Optional
	public String icon;
	@Optional
	public String selected;
	
	public Option() {
		super(AnnotationType.OPTION);
	}
}
