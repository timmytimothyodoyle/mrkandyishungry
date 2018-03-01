package com.netcentric.brainery.yamldialog.common.validation.rule.number;

import com.netcentric.brainery.yamldialog.api.model.yaml.Numberfield;
import com.netcentric.brainery.yamldialog.api.validation.ItemValidationRule;
import com.netcentric.brainery.yamldialog.api.validation.ValidationResult;
import com.netcentric.brainery.yamldialog.api.validation.model.Severity;
import com.netcentric.brainery.yamldialog.utils.Utils;

public class NumberRangeValidationRule implements ItemValidationRule<Numberfield> {

	@Override
	public ValidationResult pass(Numberfield item) {
		if (!Utils.isNumeric(item.min)) {
			return ValidationResult.invalid(Severity.SEVERE, "min value is not numeric", item);
		}
		if (!Utils.isNumeric(item.max)) {
			return ValidationResult.invalid(Severity.SEVERE, "max value is not numeric", item);
		}
		if (Utils.number(item.min) > Utils.number(item.max)) {
			return ValidationResult.invalid(Severity.SEVERE, "min value is greater than max value", item);
		}
		return ValidationResult.valid();
	}

}
