package com.netcentric.brainery.yamldialog.common.validation.rule.date;

import com.netcentric.brainery.yamldialog.api.model.yaml.Calendar;
import com.netcentric.brainery.yamldialog.api.validation.ItemValidationRule;
import com.netcentric.brainery.yamldialog.api.validation.ValidationResult;
import com.netcentric.brainery.yamldialog.api.validation.model.Severity;
import com.netcentric.brainery.yamldialog.utils.DateUtils;

public class DateRangeValidationRule implements ItemValidationRule<Calendar> {

	private static final String DATE_INVALID_DATE = "[%s] with  is not a valid date, valid format [%s]";

	@Override
	public ValidationResult pass(Calendar item) {
		String format = item.format != null ? item.format : DateUtils.DEFAULT_DATE_FORMAT;
		if (DateUtils.isDateFormat(format)) {
			if (item.value != null && !DateUtils.isDate(item.value, format)) {
				return ValidationResult.invalid(Severity.SEVERE, String.format(DATE_INVALID_DATE, item.value, format),
						item);
			}
			if (item.mindate != null && !DateUtils.isDate(item.mindate, format)) {
				return ValidationResult.invalid(Severity.SEVERE, "mindate is not a valid date, valid format " + format,
						item);
			}
			if (item.maxdate != null && !DateUtils.isDate(item.maxdate, format)) {
				return ValidationResult.invalid(Severity.SEVERE, "maxdate is not a valid date, valid format " + format,
						item);
			}
			if (DateUtils.greaterThan(item.mindate, item.maxdate, format)) {
				return ValidationResult.invalid(Severity.SEVERE, "mindate is greater than maxdate", item);
			}
			if (DateUtils.greaterThan(item.mindate, item.value, format)) {
				return ValidationResult.invalid(Severity.SEVERE, "value is lower than mindate", item);
			}
			if (DateUtils.greaterThan(item.value, item.maxdate, format)) {
				return ValidationResult.invalid(Severity.SEVERE, "value is greater than maxdate", item);
			}
		}
		return ValidationResult.valid();
	}
}