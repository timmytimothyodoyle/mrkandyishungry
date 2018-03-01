package com.netcentric.brainery.yamldialog.api.validation;

import com.netcentric.brainery.yamldialog.api.model.AnnotationItem;

public interface ItemValidationRule<E extends AnnotationItem> {

	public ValidationResult pass(E item);
}
