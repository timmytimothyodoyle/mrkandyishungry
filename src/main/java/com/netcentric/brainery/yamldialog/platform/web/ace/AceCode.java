package com.netcentric.brainery.yamldialog.platform.web.ace;

import com.netcentric.brainery.yamldialog.api.model.Item;

public class AceCode implements Item {

	private String code;

	private String type;

	private String language;

	public AceCode(String code, String type, String language) {
		this.code = code;
		this.type = type;
		this.language = language;
	}

	@Override
	public boolean isValid() {
		return true;
	}

	public String getCode() {
		return code;
	}

	public String getType() {
		return type;
	}

	public String getLanguage() {
		return language;
	}

}
