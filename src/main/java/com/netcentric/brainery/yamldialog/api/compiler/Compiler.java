package com.netcentric.brainery.yamldialog.api.compiler;

import com.netcentric.brainery.yamldialog.api.model.ExportItem;
import com.netcentric.brainery.yamldialog.api.validation.model.Conflicts;

public interface Compiler {

	public Conflicts compile(String yamlcode);
	
	public ExportItem build(String yamlcode);
}
