package com.netcentric.brainery.yamldialog.platform.web.ace.builder;

import com.netcentric.brainery.yamldialog.platform.web.ace.AceCode;
import com.netcentric.brainery.yamldialog.platform.web.ace.AceConflicts;
import com.netcentric.brainery.yamldialog.platform.web.ace.AceOutput;

public class AceOutputBuilder {

	private AceOutput output;

	public AceOutputBuilder() {
		output = new AceOutput();
	}

	public AceOutputBuilder code(AceCode code) {
		output.setCode(code);
		return this;
	}
	
	public AceOutputBuilder editConfing(AceCode editConfig) {
		output.setEditConfig(editConfig);
		return this;
	}

	public AceOutputBuilder conflicts(AceConflicts conflicts) {
		output.setConflicts(conflicts);
		return this;
	}

	public AceOutput build() {
		return output;
	}
}
