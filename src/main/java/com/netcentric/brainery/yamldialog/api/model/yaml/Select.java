package com.netcentric.brainery.yamldialog.api.model.yaml;

import java.util.List;

import com.netcentric.brainery.yamldialog.api.model.AnnotationItem;
import com.netcentric.brainery.yamldialog.api.model.AnnotationType;
import com.netcentric.brainery.yamldialog.api.model.annotation.Optional;
import com.netcentric.brainery.yamldialog.api.model.annotation.Required;

public class Select extends AnnotationItem {

	@Required
	public String name;
	@Required
	public String title;
	@Optional
	public String empty;
	@Optional
	public String target;
	@Optional
	public String validation;
	@Optional
	public String description;
	@Optional
	public String defaultvalue;
	@Optional
	public Boolean ordered;
	@Optional
	public Boolean multiple;
	@Optional
	public Boolean translate;
	@Optional
	public List<Option> items;
	
	public Select() {
		super(AnnotationType.SELECT);
	}
}
