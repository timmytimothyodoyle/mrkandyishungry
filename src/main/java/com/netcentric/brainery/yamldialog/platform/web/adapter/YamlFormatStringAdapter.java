package com.netcentric.brainery.yamldialog.platform.web.adapter;

import java.util.HashMap;
import java.util.Map;

import com.netcentric.brainery.yamldialog.api.adapter.AnyAdapter;

public class YamlFormatStringAdapter implements AnyAdapter<String, String> {

	private Map<String, String> properties;

	public YamlFormatStringAdapter() {
		properties = new HashMap<String, String>();
		properties.put("default", "defaultvalue");
	}

	public String adapt(String code) {
		return adaptIndent(adaptDefaultValues(code));
	}

	private String adaptIndent(String code) {
		return code;
	}

	private String adaptDefaultValues(String code) {
		String adapted = code;
		for (String property : properties.keySet()) {
			adapted = adapted.replaceAll(property, properties.get(property));
		}
		return adapted;
	}

}
