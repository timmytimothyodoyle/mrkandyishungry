package com.netcentric.brainery.yamldialog.api.model.yaml;

import com.netcentric.brainery.yamldialog.api.model.AnnotationItem;
import com.netcentric.brainery.yamldialog.api.model.AnnotationType;
import com.netcentric.brainery.yamldialog.api.model.annotation.Required;
import com.netcentric.brainery.yamldialog.utils.Utils;

public class Text extends AnnotationItem {

	@Required
	public String name = Utils.randomize("text");
	@Required
	public String text;
	
	public Text() {
		super(AnnotationType.TEXT);
	}
}