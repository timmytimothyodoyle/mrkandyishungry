package com.netcentric.brainery.yamldialog.common.model;

import com.netcentric.brainery.yamldialog.api.model.Item;
import com.netcentric.brainery.yamldialog.utils.Utils;

public class YdbProject implements Item {

	private String code;

	private String destination;

	public YdbProject(String code, String destination) {
		this.code = Utils.format(code);
		this.destination = destination;
	}

	@Override
	public boolean isValid() {
		return code != null && destination != null;
	}

	public String getCode() {
		return code;
	}

	public String getDestination() {
		return destination;
	}
}
