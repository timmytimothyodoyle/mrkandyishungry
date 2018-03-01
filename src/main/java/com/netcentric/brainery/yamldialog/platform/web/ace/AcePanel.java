package com.netcentric.brainery.yamldialog.platform.web.ace;

import com.netcentric.brainery.yamldialog.api.model.Item;

public class AcePanel implements Item {

	private String name;
	
	private String code;

	private String title;

	public AcePanel(String name, String title, String code) {
		this.name = name;
		this.code = code;
		this.title = title;
	}

	public String getName() {
		return name;
	}

	public String getCode() {
		return code;
	}

	public String getTitle() {
		return title;
	}

	@Override
	public boolean isValid() {
		return false;
	}

}
