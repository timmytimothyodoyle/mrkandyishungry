package com.netcentric.brainery.yamldialog.api.service;

import com.netcentric.brainery.yamldialog.api.model.DialogType;
import com.netcentric.brainery.yamldialog.api.model.TemplateItem;
import com.netcentric.brainery.yamldialog.api.model.AnnotationType;

public interface TemplateProvider {

	public TemplateItem get(DialogType type, AnnotationType template);
}
