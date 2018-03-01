package com.netcentric.brainery.yamldialog.common.validation;

import java.util.Collections;
import java.util.List;

import com.netcentric.brainery.yamldialog.api.model.AnnotationItem;
import com.netcentric.brainery.yamldialog.api.model.yaml.Fieldset;

public class FieldsetValidation extends ItemsContainerValidation<Fieldset> {

	@Override
	protected List<AnnotationItem> getItems(Fieldset item) {
		return item.isValid() ? item.items : Collections.emptyList();
	}

}