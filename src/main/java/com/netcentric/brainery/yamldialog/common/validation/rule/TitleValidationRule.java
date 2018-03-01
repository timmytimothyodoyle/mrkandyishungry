package com.netcentric.brainery.yamldialog.common.validation.rule;

import com.netcentric.brainery.yamldialog.api.model.AnnotationItem;
import com.netcentric.brainery.yamldialog.api.validation.ItemValidationRule;
import com.netcentric.brainery.yamldialog.api.validation.ValidationResult;

public class TitleValidationRule implements ItemValidationRule<AnnotationItem> {

	@Override
	public ValidationResult pass(AnnotationItem item) {
		return ValidationResult.valid();
	}

}
