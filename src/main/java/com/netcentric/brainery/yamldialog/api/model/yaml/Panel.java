package com.netcentric.brainery.yamldialog.api.model.yaml;

import java.util.List;

import com.netcentric.brainery.yamldialog.api.model.AnnotationItem;
import com.netcentric.brainery.yamldialog.api.model.AnnotationType;
import com.netcentric.brainery.yamldialog.api.model.annotation.Required;
import com.netcentric.brainery.yamldialog.utils.Utils;

public class Panel extends AnnotationItem {

	@Required
	public String name = Utils.randomize("rndpanel");
	@Required
	public String title = Utils.randomize("rndtitle");
	@Required
	public List<AnnotationItem> items;

	public Panel() {
		super(AnnotationType.PANEL);
	}
}
