package com.netcentric.brainery.yamldialog.common.validation.rule.date;

import com.netcentric.brainery.yamldialog.api.model.yaml.Calendar;
import com.netcentric.brainery.yamldialog.api.validation.ItemValidationRule;
import com.netcentric.brainery.yamldialog.api.validation.ValidationResult;
import com.netcentric.brainery.yamldialog.api.validation.model.Severity;
import com.netcentric.brainery.yamldialog.utils.DateUtils;

public class DateFormatValidationRule implements ItemValidationRule<Calendar> {
	
	private static final String DATE_INVALID_FORMAT = "format [%s] is not a valid date format";

	@Override
	public ValidationResult pass(Calendar item) {
		if (item.format != null && !DateUtils.isDateFormat(item.format)) {
			return ValidationResult.invalid(Severity.SEVERE, String.format(DATE_INVALID_FORMAT, item.format), item);
		}
		return ValidationResult.valid();
	}

}