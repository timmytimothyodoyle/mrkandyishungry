package com.netcentric.brainery.yamldialog.common.validation.rule.pathfield;

import com.netcentric.brainery.yamldialog.api.model.yaml.Pathfield;
import com.netcentric.brainery.yamldialog.api.validation.ItemValidationRule;
import com.netcentric.brainery.yamldialog.api.validation.ValidationResult;
import com.netcentric.brainery.yamldialog.api.validation.model.Severity;
import com.netcentric.brainery.yamldialog.utils.Utils;

public class RootValidationRule implements ItemValidationRule<Pathfield> {

	@Override
	public ValidationResult pass(Pathfield item) {
		if(Utils.isEmpty(item.root)) {
			return ValidationResult.invalid(Severity.WARNING, "root not specified, by default is pointing to / (root of the system)", item);
		} else if(!isValid(item.root)) {
			return ValidationResult.invalid(Severity.SEVERE, "rootPath is pointing to an invalid internal path", item);
		}
		return ValidationResult.valid();
	}

	private boolean isValid(String root) {
		return root.startsWith("/content") || root.startsWith("/etc");
	}

}