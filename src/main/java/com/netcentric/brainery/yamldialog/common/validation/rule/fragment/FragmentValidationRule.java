package com.netcentric.brainery.yamldialog.common.validation.rule.fragment;

import com.netcentric.brainery.yamldialog.api.model.yaml.Fragment;
import com.netcentric.brainery.yamldialog.api.validation.ItemValidationRule;
import com.netcentric.brainery.yamldialog.api.validation.ValidationResult;

public class FragmentValidationRule implements ItemValidationRule<Fragment> {

	@Override
	public ValidationResult pass(Fragment item) {
		System.out.println("TODO: ImportValidationRule");
		return ValidationResult.valid();
	}

}
