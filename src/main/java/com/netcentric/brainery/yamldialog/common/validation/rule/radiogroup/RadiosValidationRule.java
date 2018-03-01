package com.netcentric.brainery.yamldialog.common.validation.rule.radiogroup;

import com.netcentric.brainery.yamldialog.api.model.yaml.Radiogroup;
import com.netcentric.brainery.yamldialog.api.validation.ItemValidationRule;
import com.netcentric.brainery.yamldialog.api.validation.ValidationResult;
import com.netcentric.brainery.yamldialog.api.validation.model.Severity;
import com.netcentric.brainery.yamldialog.utils.Utils;

public class RadiosValidationRule implements ItemValidationRule<Radiogroup> {

	@Override
	public ValidationResult pass(Radiogroup item) {
		if (Utils.empty(item.items)) {
			return ValidationResult.invalid(Severity.SEVERE, "radios are missing in radiogroup, define at least one", item);
		}
		return ValidationResult.valid();
	}

}
