package com.netcentric.brainery.yamldialog.api.model.yaml;

public class NullDialog extends Dialog {

	private Exception e;

	public NullDialog() {
	}

	public NullDialog(Exception e) {
		this();
		this.e = e;
	}

	public boolean isValid() {
		return false;
	}

	public Exception getException() {
		return e;
	}
}
