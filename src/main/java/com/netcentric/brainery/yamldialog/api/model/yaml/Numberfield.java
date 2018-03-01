package com.netcentric.brainery.yamldialog.api.model.yaml;

import com.netcentric.brainery.yamldialog.api.model.AnnotationItem;
import com.netcentric.brainery.yamldialog.api.model.AnnotationType;
import com.netcentric.brainery.yamldialog.api.model.annotation.Optional;
import com.netcentric.brainery.yamldialog.api.model.annotation.Required;

public class Numberfield extends AnnotationItem {

	@Required
	public String name;
	@Required
	public String title;
	@Optional
	public String max;
	@Optional
	public String min;
	@Optional
	public String step;
	@Optional
	public String value;
	@Optional
	public String description;
	
	public Numberfield() {
		super(AnnotationType.NUMBERFIELD);
	}
}