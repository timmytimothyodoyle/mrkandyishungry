package com.netcentric.brainery.yamldialog.api.validation;

import java.util.Optional;

import com.netcentric.brainery.yamldialog.api.model.AnnotationItem;
import com.netcentric.brainery.yamldialog.api.validation.model.Conflict;
import com.netcentric.brainery.yamldialog.api.validation.model.Severity;

public interface ValidationResult {

	static ValidationResult valid() {
		return ValidationSupport.valid();
	}

	static ValidationResult invalid(Severity severity, String reason, AnnotationItem item) {
		return new Invalid(item, severity, reason);
	}

	boolean isValid();

	Optional<Conflict> getConflict();
}

final class Invalid implements ValidationResult {

	private final String reason;
	private final Severity severity;
	private final AnnotationItem item;

	Invalid(AnnotationItem item, Severity severity, String reason) {
		this.item = item;
		this.reason = reason;
		this.severity = severity;
	}

	public boolean isValid() {
		return false;
	}

	public Optional<Conflict> getConflict() {
		return Optional.of(new Conflict(severity, reason, item));
	}

	// equals and hashCode on field reason
}

final class ValidationSupport {
	private static final ValidationResult valid = new ValidationResult() {
		public boolean isValid() {
			return true;
		}

		@Override
		public Optional<Conflict> getConflict() {
			return Optional.empty();
		}
	};

	static ValidationResult valid() {
		return valid;
	}
}