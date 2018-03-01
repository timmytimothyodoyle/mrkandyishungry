package com.netcentric.brainery.yamldialog.common.adapter;

import java.util.regex.Pattern;

import com.netcentric.brainery.yamldialog.api.adapter.AnyAdapter;

public class PostProcessorAdapter implements AnyAdapter<String, String> {

	@Override
	public String adapt(String param) {
		return param.replaceAll(Pattern.quote("&^&"), "\\$");
	}

}
