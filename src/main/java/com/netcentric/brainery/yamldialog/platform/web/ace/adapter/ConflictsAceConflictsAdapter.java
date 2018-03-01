package com.netcentric.brainery.yamldialog.platform.web.ace.adapter;

import com.netcentric.brainery.yamldialog.api.adapter.AnyAdapter;
import com.netcentric.brainery.yamldialog.api.validation.model.Conflict;
import com.netcentric.brainery.yamldialog.api.validation.model.Conflicts;
import com.netcentric.brainery.yamldialog.platform.web.ace.AceConflict;
import com.netcentric.brainery.yamldialog.platform.web.ace.AceConflicts;

public class ConflictsAceConflictsAdapter implements AnyAdapter<AceConflicts, Conflicts> {

	@Override
	public AceConflicts adapt(Conflicts conflicts) {
		AceConflicts aceConflicts = new AceConflicts();
		for (Conflict conflict : conflicts.list()) {
			aceConflicts.add(new AceConflict(conflict));
		}
		return aceConflicts;
	}

}
