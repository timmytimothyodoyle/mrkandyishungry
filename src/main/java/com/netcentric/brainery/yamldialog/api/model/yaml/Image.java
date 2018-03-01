package com.netcentric.brainery.yamldialog.api.model.yaml;

import com.netcentric.brainery.yamldialog.api.model.AnnotationItem;
import com.netcentric.brainery.yamldialog.api.model.AnnotationType;
import com.netcentric.brainery.yamldialog.api.model.annotation.Optional;
import com.netcentric.brainery.yamldialog.api.model.annotation.Required;

public class Image extends AnnotationItem {

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
	@Optional
	public String mime = "image";
	@Optional
	public Long size;
	@Optional
	public Boolean async;
	@Optional
	public Boolean multiple = false;

	public Image() {
		super(AnnotationType.IMAGE);
	}
}