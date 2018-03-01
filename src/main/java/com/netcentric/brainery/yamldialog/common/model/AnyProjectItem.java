package com.netcentric.brainery.yamldialog.common.model;

import java.util.StringJoiner;

import com.netcentric.brainery.yamldialog.api.model.ExportItem;
import com.netcentric.brainery.yamldialog.api.validation.model.Conflicts;
import com.netcentric.brainery.yamldialog.common.TemplateKey;

public class AnyProjectItem implements ExportItem {

	private Conflicts conflitcs;

	private AnyExportItem dialog;

	private AnyExportItem content;

	private AnyExportItem editconfig;

	@Override
	public boolean isValid() {
		return dialog != null && content != null && editconfig != null && conflitcs != null;
	}

	@Override
	public TemplateKey getKey() {
		return null;
	}

	public void setDialog(AnyExportItem dialog) {
		this.dialog = dialog;
	}

	public void setConflicts(Conflicts conflitcs) {
		this.conflitcs = conflitcs;
	}

	public void setContent(AnyExportItem content) {
		this.content = content;
	}

	public void setEditConfig(AnyExportItem editconfig) {
		this.editconfig = editconfig;
	}

	public AnyExportItem getDialog() {
		return dialog;
	}

	public AnyExportItem getContent() {
		return content;
	}

	public AnyExportItem getEditConfig() {
		return editconfig;
	}

	public Conflicts getConflitcs() {
		return conflitcs;
	}

	@Override
	public String toString() {
		StringJoiner joiner = new StringJoiner("\n----\n");
		joiner.add(dialog.getItem());
		joiner.add(content.getItem());
		joiner.add(editconfig.getItem());
		joiner.add(conflitcs.toString());
		return joiner.toString();
	}

}
