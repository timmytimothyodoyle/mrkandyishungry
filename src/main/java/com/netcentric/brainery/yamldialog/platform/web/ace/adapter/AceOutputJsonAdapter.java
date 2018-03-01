package com.netcentric.brainery.yamldialog.platform.web.ace.adapter;

import com.google.gson.JsonObject;
import com.netcentric.brainery.yamldialog.api.adapter.AnyAdapter;
import com.netcentric.brainery.yamldialog.platform.web.ace.AceOutput;

public class AceOutputJsonAdapter implements AnyAdapter<JsonObject, AceOutput> {

	private AceCodeJsonAdapter codeAdapter;

	private AceConflictsJsonAdapter conflictsAdapter;

	public AceOutputJsonAdapter() {
		codeAdapter = new AceCodeJsonAdapter();
		conflictsAdapter = new AceConflictsJsonAdapter();
	}

	@Override
	public JsonObject adapt(AceOutput output) {
		JsonObject adapted = new JsonObject();
		adapted.add("code", codeAdapter.adapt(output.getCode()));
		adapted.add("console", conflictsAdapter.adapt(output.getConflicts()));
		adapted.add("editConfig", codeAdapter.adapt(output.getEditConfig()));
		return adapted;
	}

}
