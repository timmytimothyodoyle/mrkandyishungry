package com.netcentric.brainery.yamldialog.api.model.yaml;

import com.netcentric.brainery.yamldialog.api.model.AnnotationItem;
import com.netcentric.brainery.yamldialog.api.model.AnnotationType;
import com.netcentric.brainery.yamldialog.api.model.annotation.Optional;
import com.netcentric.brainery.yamldialog.api.model.annotation.Required;

public class Switch extends AnnotationItem {

	@Required
	public String name;
	@Required
	public String title;
	@Optional
	public String on;
	@Optional
	public String off;
	@Optional
	public String clazz;
	@Optional
	public String checked;
	@Optional
	public String unchecked;
	@Optional
	public String description;
	@Optional
	public Boolean defaultvalue;
	
	public Switch() {
		super(AnnotationType.SWITCH);
	}
}
