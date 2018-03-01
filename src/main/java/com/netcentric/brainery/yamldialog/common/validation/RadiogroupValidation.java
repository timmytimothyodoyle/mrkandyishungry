package com.netcentric.brainery.yamldialog.common.validation;

import com.netcentric.brainery.yamldialog.api.model.yaml.Radio;
import com.netcentric.brainery.yamldialog.api.model.yaml.Radiogroup;
import com.netcentric.brainery.yamldialog.api.validation.ItemValidation;
import com.netcentric.brainery.yamldialog.api.validation.model.Conflicts;
import com.netcentric.brainery.yamldialog.utils.Utils;

import static com.netcentric.brainery.yamldialog.common.factory.ItemValidationRuleFactory.make;

public class RadiogroupValidation implements ItemValidation<Radiogroup> {

	@Override
	public Conflicts validate(Radiogroup item) {
		// apply the existing validation rules to the select
		Conflicts conflicts = make(item).apply(item);
		for (Radio radio : Utils.safe(item.items, Radio.class)) {
			conflicts.add(make(radio).apply(radio).list());
		}
		return conflicts;
	}

	@Override
	public boolean isValid() {
		return true;
	}

}
