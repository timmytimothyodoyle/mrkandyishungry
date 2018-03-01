package com.netcentric.brainery.yamldialog.platform.web.ace.adapter;

import com.google.gson.JsonObject;
import com.netcentric.brainery.yamldialog.api.adapter.AnyAdapter;
import com.netcentric.brainery.yamldialog.api.model.AnnotationItem;
import com.netcentric.brainery.yamldialog.platform.web.ace.AceConflict;
import com.netcentric.brainery.yamldialog.utils.ModelUtils;

public class AceConflictJsonAdapter implements AnyAdapter<JsonObject, AceConflict> {

	@Override
	public JsonObject adapt(AceConflict conflict) {
		JsonObject adapted = new JsonObject();
		AnnotationItem item = conflict.getItem();
		adapted.addProperty("line", conflict.getLine());
		adapted.addProperty("type", ModelUtils.adapt(item.getClass()));
		adapted.addProperty("reason", conflict.getReason());
		adapted.addProperty("severity", conflict.getSeverity().name());
		return adapted;
	}

}
