package com.netcentric.brainery.yamldialog.api.model.yaml;

import com.netcentric.brainery.yamldialog.api.model.AnnotationItem;
import com.netcentric.brainery.yamldialog.api.model.AnnotationType;
import com.netcentric.brainery.yamldialog.api.model.annotation.Optional;
import com.netcentric.brainery.yamldialog.api.model.annotation.Required;

public class Radio extends AnnotationItem {

	public int id;
	@Required
	public String text;
	@Required
	public String value;
	@Optional
	public Boolean checked;
	@Optional
	public Boolean disabled;
	
	public Radio() {
		super(AnnotationType.RADIO);
	}
}
