package com.netcentric.brainery.yamldialog.common.validation.rule.select;

import com.netcentric.brainery.yamldialog.api.model.yaml.Option;
import com.netcentric.brainery.yamldialog.api.model.yaml.Select;
import com.netcentric.brainery.yamldialog.api.validation.ItemValidationRule;
import com.netcentric.brainery.yamldialog.api.validation.ValidationResult;
import com.netcentric.brainery.yamldialog.api.validation.model.Severity;

public class DefaultValidationRule implements ItemValidationRule<Select> {

	@Override
	public ValidationResult pass(Select item) {
		if (item.defaultvalue == null) {
			return ValidationResult.valid();
		} else {
			for (Option option : item.items) {
				if (option.value != null && option.value.equals(item.defaultvalue)) {
					return ValidationResult.valid();
				}
			}
		}
		return ValidationResult.invalid(Severity.WARNING, "default value is not in declared values", item);
	}

}
