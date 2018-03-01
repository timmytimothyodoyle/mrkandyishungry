package com.netcentric.brainery.yamldialog.api.model.yaml;

import com.netcentric.brainery.yamldialog.api.model.AnnotationItem;
import com.netcentric.brainery.yamldialog.api.model.AnnotationType;
import com.netcentric.brainery.yamldialog.api.model.annotation.Optional;
import com.netcentric.brainery.yamldialog.api.model.annotation.Required;

public class Tagfield extends AnnotationItem {

	public static enum TagfieldType {
		EXPLORER, AUTOCOMPLETE;

		public String toString() {
			return name().toLowerCase();
		}
	};

	@Required
	public String name;
	@Required
	public String title;
	@Optional
	public String type = TagfieldType.EXPLORER.toString();
	@Optional
	public String empty;
	@Optional
	public String validation;
	@Optional
	public String description;
	@Optional
	public Boolean multiple;

	public Tagfield() {
		super(AnnotationType.TAGFIELD);
	}
}
