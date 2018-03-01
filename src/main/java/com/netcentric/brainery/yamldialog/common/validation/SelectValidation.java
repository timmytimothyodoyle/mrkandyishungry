package com.netcentric.brainery.yamldialog.common.validation;

import static com.netcentric.brainery.yamldialog.common.factory.ItemValidationRuleFactory.make;

import com.netcentric.brainery.yamldialog.api.model.yaml.Option;
import com.netcentric.brainery.yamldialog.api.model.yaml.Select;
import com.netcentric.brainery.yamldialog.api.validation.ItemValidation;
import com.netcentric.brainery.yamldialog.api.validation.model.Conflicts;

public class SelectValidation implements ItemValidation<Select> {

	@Override
	public Conflicts validate(Select item) {
		// apply the existing validation rules to the select
		Conflicts conflicts = make(item).apply(item);
		for (Option option : item.items) {
			conflicts.add(make(option).apply(option).list());
		}
		return conflicts;
	}

	@Override
	public boolean isValid() {
		return true;
	}

}
