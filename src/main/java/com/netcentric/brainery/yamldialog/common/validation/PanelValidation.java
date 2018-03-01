package com.netcentric.brainery.yamldialog.common.validation;

import java.util.Collections;
import java.util.List;

import com.netcentric.brainery.yamldialog.api.model.AnnotationItem;
import com.netcentric.brainery.yamldialog.api.model.yaml.Panel;

public class PanelValidation extends ItemsContainerValidation<Panel> {

	@Override
	protected List<AnnotationItem> getItems(Panel item) {
		return item.isValid() ? item.items : Collections.emptyList();
	}
	
}