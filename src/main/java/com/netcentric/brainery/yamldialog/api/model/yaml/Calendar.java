package com.netcentric.brainery.yamldialog.api.model.yaml;

import com.netcentric.brainery.yamldialog.api.model.AnnotationItem;
import com.netcentric.brainery.yamldialog.api.model.AnnotationType;
import com.netcentric.brainery.yamldialog.api.model.annotation.Optional;
import com.netcentric.brainery.yamldialog.api.model.annotation.Required;

public class Calendar extends AnnotationItem {
	
	@Required
	public String name;
	@Required
	public String title;
	@Optional
	public String empty;
	@Optional
	public String value;
	@Optional
	public String format;
	@Optional
	public String maxdate;
	@Optional
	public String mindate;
	@Optional
	public String validation;
	@Optional
	public String description;
	@Optional
	public Boolean timezone;
	
	public Calendar() {
		super(AnnotationType.CALENDAR);
	}
}
