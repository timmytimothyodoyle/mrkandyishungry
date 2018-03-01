package com.netcentric.brainery.yamldialog.common.validation.rule;

import java.lang.reflect.Field;

import com.netcentric.brainery.yamldialog.api.model.AnnotationItem;
import com.netcentric.brainery.yamldialog.api.validation.ItemValidationRule;
import com.netcentric.brainery.yamldialog.api.validation.ValidationResult;
import com.netcentric.brainery.yamldialog.api.validation.model.Severity;
import com.netcentric.brainery.yamldialog.utils.Utils;

public class NameValidationRule implements ItemValidationRule<AnnotationItem> {

	@Override
	public ValidationResult pass(AnnotationItem item) {
		try {
			Field field = item.getClass().getDeclaredField("name");
			Object value = field.get(item);
			if (!isValid(value)) {
				return ValidationResult.invalid(Severity.SEVERE, "name contains invalid characters, blank spaces not allowed",
						item);
			}
		} catch (Exception e) {
			return ValidationResult.invalid(Severity.SEVERE, "[myBAD] unable to get name value", item);
		}
		return ValidationResult.valid();
	}

	private boolean isValid(Object name) {
		if (name != null)
			return !name.toString().contains(Utils.BLANK_STR);
		return true;
	}

}