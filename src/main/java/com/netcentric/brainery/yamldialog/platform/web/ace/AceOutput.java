package com.netcentric.brainery.yamldialog.platform.web.ace;

import com.netcentric.brainery.yamldialog.api.model.Item;

public class AceOutput implements Item {

	private AceCode code;

	private AceCode editConfig;

	private AceConflicts conflicts;

	public AceCode getCode() {
		return code;
	}
	
	public AceCode getEditConfig() {
		return editConfig;
	}

	public AceConflicts getConflicts() {
		return conflicts;
	}

	@Override
	public boolean isValid() {
		return code != null && editConfig != null && conflicts != null;
	}

	public void setCode(AceCode code) {
		this.code = code;
	}

	public void setConflicts(AceConflicts conflicts) {
		this.conflicts = conflicts;
	}

	public void setEditConfig(AceCode editConfig) {
		this.editConfig = editConfig;
	}

}
