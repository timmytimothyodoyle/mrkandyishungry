package com.netcentric.brainery.yamldialog.common.validation;

import java.util.Collections;
import java.util.List;

import com.netcentric.brainery.yamldialog.api.model.AnnotationItem;
import com.netcentric.brainery.yamldialog.api.model.yaml.Multifield;

public class MultifieldValidation extends ItemsContainerValidation<Multifield> {

	@Override
	protected List<AnnotationItem> getItems(Multifield item) {
		return item.isValid() ? item.items : Collections.emptyList();
	}

}