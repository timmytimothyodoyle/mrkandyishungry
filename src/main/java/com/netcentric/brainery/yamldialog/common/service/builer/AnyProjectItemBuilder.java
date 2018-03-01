package com.netcentric.brainery.yamldialog.common.service.builer;

import com.netcentric.brainery.yamldialog.api.validation.model.Conflicts;
import com.netcentric.brainery.yamldialog.common.model.AnyExportItem;
import com.netcentric.brainery.yamldialog.common.model.AnyProjectItem;

public class AnyProjectItemBuilder {

	private AnyProjectItem anyproject = new AnyProjectItem();

	public AnyProjectItemBuilder dialog(AnyExportItem item) {
		anyproject.setDialog(item);
		return this;
	}

	public AnyProjectItemBuilder editconfig(AnyExportItem item) {
		anyproject.setEditConfig(item);
		return this;
	}

	public AnyProjectItemBuilder content(AnyExportItem item) {
		anyproject.setContent(item);
		return this;
	}
	
	public AnyProjectItemBuilder conflicts(Conflicts conflicts) {
		anyproject.setConflicts(conflicts);
		return this;
	}

	public AnyProjectItem build() {
		return anyproject;
	}
}
