package com.netcentric.brainery.yamldialog.api.validation.model;

import java.util.StringJoiner;

import com.netcentric.brainery.yamldialog.common.model.ItemCollection;

public class Conflicts extends ItemCollection<Conflict> {

	public void add(Conflict conflict) {
		if (conflict.isValid()) {
			super.add(conflict);
		}
	}

	public void add(Conflicts conflicts) {
		for (Conflict conflict : conflicts.list()) {
			if (conflict.isValid()) {
				add(conflict);
			}
		}
	}

	@Override
	public String toString() {
		StringJoiner joiner = new StringJoiner(", ");
		for (Conflict conflict : list()) {
			joiner.add(conflict.getReason());
		}
		return joiner.toString();
	}
}
