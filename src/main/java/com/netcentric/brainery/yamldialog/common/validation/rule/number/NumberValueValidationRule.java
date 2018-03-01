package com.netcentric.brainery.yamldialog.common.validation.rule.number;

import com.netcentric.brainery.yamldialog.api.model.yaml.Numberfield;
import com.netcentric.brainery.yamldialog.api.validation.ItemValidationRule;
import com.netcentric.brainery.yamldialog.api.validation.ValidationResult;
import com.netcentric.brainery.yamldialog.api.validation.model.Severity;
import com.netcentric.brainery.yamldialog.utils.Utils;

public class NumberValueValidationRule implements ItemValidationRule<Numberfield> {

	@Override
	public ValidationResult pass(Numberfield item) {
		if (!Utils.isNumeric(item.value)) {
			return ValidationResult.invalid(Severity.SEVERE, "value is not numeric", item);
		}
		if (Utils.number(item.min) > Utils.number(item.value)) {
			return ValidationResult.invalid(Severity.SEVERE, "min value is greater than value", item);
		}
		if (Utils.number(item.max) < Utils.number(item.value)) {
			return ValidationResult.invalid(Severity.SEVERE, "max value is lower than value", item);
		}
		return ValidationResult.valid();
	}

}
