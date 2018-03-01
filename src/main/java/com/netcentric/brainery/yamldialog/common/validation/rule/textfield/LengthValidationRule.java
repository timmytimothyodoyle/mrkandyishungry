package com.netcentric.brainery.yamldialog.common.validation.rule.textfield;

import com.netcentric.brainery.yamldialog.api.model.yaml.Textfield;
import com.netcentric.brainery.yamldialog.api.validation.ItemValidationRule;
import com.netcentric.brainery.yamldialog.api.validation.ValidationResult;
import com.netcentric.brainery.yamldialog.api.validation.model.Severity;
import com.netcentric.brainery.yamldialog.utils.Utils;

public class LengthValidationRule implements ItemValidationRule<Textfield> {

	@Override
	public ValidationResult pass(Textfield item) {
		if (item.maxlength != null && !Utils.isNumeric(item.maxlength)) {
			return ValidationResult.invalid(Severity.WARNING, "max length value is not numeric", item);
		}
		return ValidationResult.valid();
	}

}
