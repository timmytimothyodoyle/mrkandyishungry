package com.netcentric.brainery.yamldialog.common.validation.rule.textarea;

import com.netcentric.brainery.yamldialog.api.model.yaml.TextArea;
import com.netcentric.brainery.yamldialog.api.validation.ItemValidationRule;
import com.netcentric.brainery.yamldialog.api.validation.ValidationResult;
import com.netcentric.brainery.yamldialog.api.validation.model.Severity;
import com.netcentric.brainery.yamldialog.utils.Utils;

public class DimensionsValidationRule implements ItemValidationRule<TextArea> {

	@Override
	public ValidationResult pass(TextArea item) {
		if(item.rows != null && !Utils.isNumeric(item.rows)) {
			return ValidationResult.invalid(Severity.SEVERE, "rows is not numeric", item);
		}
		if(item.columns != null && !Utils.isNumeric(item.columns)) {
			return ValidationResult.invalid(Severity.SEVERE, "columns is not numeric", item);
		}
		return ValidationResult.valid();
	}

}
