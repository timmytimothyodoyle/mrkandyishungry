package com.netcentric.brainery.yamldialog.api.model.yaml;

import com.netcentric.brainery.yamldialog.api.model.AnnotationItem;
import com.netcentric.brainery.yamldialog.api.model.AnnotationType;
import com.netcentric.brainery.yamldialog.api.model.annotation.Required;

public class Fragment extends AnnotationItem {

	@Required
	public String name;
	@Required
	public String path;

	public Fragment() {
		super(AnnotationType.FRAGMENT);
	}
}
