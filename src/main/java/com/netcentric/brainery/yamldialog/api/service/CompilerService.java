package com.netcentric.brainery.yamldialog.api.service;

import com.netcentric.brainery.yamldialog.api.model.DialogType;
import com.netcentric.brainery.yamldialog.api.model.ExportItem;
import com.netcentric.brainery.yamldialog.api.validation.model.Conflicts;

public interface CompilerService {

	public Conflicts compile(String yamlcode, DialogType type);
	
	public ExportItem build(String yamlcode, DialogType type);

}
