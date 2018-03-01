package com.netcentric.brainery.yamldialog.platform.web.ace.adapter;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.netcentric.brainery.yamldialog.api.adapter.AnyAdapter;
import com.netcentric.brainery.yamldialog.platform.web.ace.AceConflict;
import com.netcentric.brainery.yamldialog.platform.web.ace.AceConflicts;

public class AceConflictsJsonAdapter implements AnyAdapter<JsonObject, AceConflicts> {

	private AceConflictJsonAdapter conflictAdapter;

	public AceConflictsJsonAdapter() {
		conflictAdapter = new AceConflictJsonAdapter();
	}

	@Override
	public JsonObject adapt(AceConflicts conflicts) {
		JsonArray jConflicts = new JsonArray();
		for (AceConflict conflict : conflicts.list()) {
			jConflicts.add(conflictAdapter.adapt(conflict));
		}
		JsonObject adapted = new JsonObject();
		adapted.add("conflicts", jConflicts);
		return adapted;
	}

}
