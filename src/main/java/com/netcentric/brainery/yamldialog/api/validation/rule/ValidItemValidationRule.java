package com.netcentric.brainery.yamldialog.api.validation.rule;

import java.util.stream.Collectors;

import com.netcentric.brainery.yamldialog.api.model.AnnotationItem;
import com.netcentric.brainery.yamldialog.api.validation.ItemValidationRule;
import com.netcentric.brainery.yamldialog.api.validation.ValidationResult;
import com.netcentric.brainery.yamldialog.api.validation.model.Severity;

public class ValidItemValidationRule implements ItemValidationRule<AnnotationItem> {

	@Override
	public ValidationResult pass(AnnotationItem item) {
		if (item.isValid()) {
			return ValidationResult.valid();
		}
		String invalidFields = item.getInvalid().stream().collect(Collectors.joining(","));
		if (invalidFields.isEmpty()) {
			return ValidationResult.valid();
		}
		return ValidationResult.invalid(Severity.SEVERE, invalidFields + " are required and not defined.", item);
	}

}
