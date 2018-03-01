package com.netcentric.brainery.yamldialog.api.model;

public enum DialogType {
	CLASSICUI, TOUCHUI_FOUNDATION, TOUCHUI_CORAL, EDITCONFIG;

	public String toString() {
		return name().toLowerCase().replaceAll("_", ".");
	}
}
