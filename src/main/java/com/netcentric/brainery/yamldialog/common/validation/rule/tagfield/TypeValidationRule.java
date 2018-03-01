package com.netcentric.brainery.yamldialog.common.validation.rule.tagfield;

import com.netcentric.brainery.yamldialog.api.model.yaml.Tagfield;
import com.netcentric.brainery.yamldialog.api.model.yaml.Tagfield.TagfieldType;
import com.netcentric.brainery.yamldialog.api.validation.ItemValidationRule;
import com.netcentric.brainery.yamldialog.api.validation.ValidationResult;
import com.netcentric.brainery.yamldialog.api.validation.model.Severity;
import com.netcentric.brainery.yamldialog.utils.Utils;

public class TypeValidationRule implements ItemValidationRule<Tagfield> {

	@Override
	public ValidationResult pass(Tagfield item) {
		if (!Utils.isEmpty(item.type)) {
			if (!Utils.contains(item.type, TagfieldType.class)) {
				return ValidationResult.invalid(Severity.WARNING,
						"type is not valid, default type 'explorer' set instead, otherwise choose one of this: "
								+ Utils.list(TagfieldType.class),
						item);
			}
		}
		return ValidationResult.valid();
	}

}
