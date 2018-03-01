package com.netcentric.brainery.yamldialog.common.validation;

import com.netcentric.brainery.yamldialog.api.model.AnnotationItem;
import com.netcentric.brainery.yamldialog.api.validation.ItemValidation;
import com.netcentric.brainery.yamldialog.api.validation.model.Conflicts;

public class NullValidation implements ItemValidation<AnnotationItem> {

	@Override
	public boolean isValid() {
		return false;
	}

	@Override
	public Conflicts validate(AnnotationItem item) {
		return new Conflicts();
	}

}
