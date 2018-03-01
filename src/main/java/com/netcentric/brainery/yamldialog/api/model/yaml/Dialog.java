package com.netcentric.brainery.yamldialog.api.model.yaml;

import java.util.List;

import com.netcentric.brainery.yamldialog.api.model.AnnotationItem;
import com.netcentric.brainery.yamldialog.api.model.AnnotationType;
import com.netcentric.brainery.yamldialog.api.model.annotation.Optional;
import com.netcentric.brainery.yamldialog.api.model.annotation.Required;

public class Dialog extends AnnotationItem {

	@Required
	public String title;
	@Optional
	public String group;
	@Required
	public List<Panel> items;
	@Optional
	public List<Fragment> fragments;

	public Dialog() {
		super(AnnotationType.DIALOG_SIMPLE);
	}
}
