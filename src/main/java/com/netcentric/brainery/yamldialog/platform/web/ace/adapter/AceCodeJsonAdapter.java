package com.netcentric.brainery.yamldialog.platform.web.ace.adapter;

import com.google.gson.JsonObject;
import com.netcentric.brainery.yamldialog.api.adapter.AnyAdapter;
import com.netcentric.brainery.yamldialog.platform.web.ace.AceCode;

public class AceCodeJsonAdapter implements AnyAdapter<JsonObject, AceCode> {

	@Override
	public JsonObject adapt(AceCode code) {
		JsonObject adapted = new JsonObject();
		adapted.addProperty("type", code.getType());
		adapted.addProperty("code", code.getCode());
		adapted.addProperty("language", code.getLanguage());
		return adapted;
	}

}
