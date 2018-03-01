package com.netcentric.brainery.yamldialog.api.model.yaml;

import com.netcentric.brainery.yamldialog.api.model.AnnotationItem;
import com.netcentric.brainery.yamldialog.api.model.AnnotationType;
import com.netcentric.brainery.yamldialog.api.model.annotation.Optional;
import com.netcentric.brainery.yamldialog.api.model.annotation.Required;

public class Checkbox extends AnnotationItem {

	@Required
	public String name;
	@Required
	public String title;
	@Optional
	public String description;
	@Optional
	public String checked = "true";
	@Optional
	public String unchecked = "false";
	@Optional
	public Boolean autosubmit;
	@Optional
	public Boolean defaultvalue;
	
	public Checkbox() {
		super(AnnotationType.CHECKBOX);
	}	
}
