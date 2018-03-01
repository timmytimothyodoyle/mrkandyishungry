package com.netcentric.brainery.yamldialog.api.validation.model;

import com.netcentric.brainery.yamldialog.api.model.AnnotationItem;
import com.netcentric.brainery.yamldialog.api.model.Item;

public class Conflict implements Item {

	private String reason;

	private Severity severity;
	
	private AnnotationItem item;

	public Conflict(Severity severity, String reason, AnnotationItem item) {
		this.item = item;
		this.reason = reason;
		this.severity = severity;
	}
	
	public AnnotationItem getItem() {
		return item;
	}

	public String getReason() {
		return reason;
	}

	public Severity getSeverity() {
		return severity;
	}

	@Override
	public boolean isValid() {
		return reason != null && severity != null;
	}
	
	@Override
	public String toString() {
		return severity.toString() + " " + reason + " " + item.getClass().getName();
	}

}