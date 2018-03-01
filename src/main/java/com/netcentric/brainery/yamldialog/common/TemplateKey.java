package com.netcentric.brainery.yamldialog.common;

import java.util.Objects;

import com.netcentric.brainery.yamldialog.api.model.DialogType;
import com.netcentric.brainery.yamldialog.api.model.Item;
import com.netcentric.brainery.yamldialog.api.model.AnnotationType;
import com.netcentric.brainery.yamldialog.utils.Utils;

public class TemplateKey implements Item {

	private DialogType type;

	private AnnotationType template;

	public TemplateKey(DialogType type, AnnotationType template) {
		this.type = type;
		this.template = template;
	}

	public DialogType getType() {
		return type;
	}

	public AnnotationType getTemplate() {
		return template;
	}

	@Override
	public boolean equals(Object obj) {
		return toString().equals(obj.toString());
	}

	@Override
	public String toString() {
		return type.toString() + Utils.SEPARATOR + template.toString();
	}

	@Override
	public int hashCode() {
		return Objects.hash(type.toString(), template.toString());
	}

	@Override
	public boolean isValid() {
		return type != null && template != null;
	}

}
