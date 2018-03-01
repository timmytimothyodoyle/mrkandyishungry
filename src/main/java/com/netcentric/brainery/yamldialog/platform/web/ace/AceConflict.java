package com.netcentric.brainery.yamldialog.platform.web.ace;

import com.netcentric.brainery.yamldialog.api.model.AnnotationItem;
import com.netcentric.brainery.yamldialog.api.model.Item;
import com.netcentric.brainery.yamldialog.api.validation.model.Conflict;
import com.netcentric.brainery.yamldialog.api.validation.model.Severity;

public class AceConflict implements Item {

	private int line;

	private Conflict conflict;

	public AceConflict(Conflict conflict) {
		this.line = 10;
		this.conflict = conflict;
	}

	public int getLine() {
		return line;
	}

	public String getReason() {
		return conflict.getReason();
	}

	public Severity getSeverity() {
		return conflict.getSeverity();
	}

	public AnnotationItem getItem() {
		return conflict.getItem();
	}

	@Override
	public boolean isValid() {
		return conflict != null;
	}

}
