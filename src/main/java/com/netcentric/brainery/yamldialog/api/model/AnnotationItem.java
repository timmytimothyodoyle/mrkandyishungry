package com.netcentric.brainery.yamldialog.api.model;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import com.netcentric.brainery.yamldialog.api.model.annotation.Optional;
import com.netcentric.brainery.yamldialog.api.model.annotation.Required;
import com.netcentric.brainery.yamldialog.api.validation.model.Conflict;
import com.netcentric.brainery.yamldialog.api.validation.model.Conflicts;

public abstract class AnnotationItem implements Item {

	@Optional
	public Boolean required;

	@Optional
	public Boolean disabled;

	@Required
	public AnnotationType type;
	
	public AnnotationItem(AnnotationType type) {
		this.type = type;
	}

	private Conflicts conflicts = new Conflicts();

	public boolean isValid() {
		Field[] fields = getClass().getDeclaredFields();
		for (Field field : fields) {
			try {
				if (field.getAnnotation(Required.class) != null) {
					Object value = field.get(this);
					if (value == null)
						return false;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return true;
	}

	public boolean isMandatory(String property) {
		try {
			Field field = getClass().getField(property);
			return field.getAnnotation(Required.class) != null;
		} catch (NoSuchFieldException | SecurityException e) {
			e.printStackTrace();
		}
		return false;
	}

	public List<String> getInvalid() {
		List<String> invalid = new ArrayList<String>();
		Field[] fields = getClass().getDeclaredFields();
		for (Field field : fields) {
			try {
				if (field.getAnnotation(Required.class) != null) {
					Object value = field.get(this);
					if (value == null) {
						invalid.add(field.getName());
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return invalid;
	}

	public void conflict(Conflict conflict) {
		if (conflict.isValid())
			conflicts.add(conflict);
	}

	public boolean hasConflicts() {
		return conflicts.isEmpty();
	}

	public Conflicts getConflicts() {
		return conflicts;
	}

	public AnnotationType getType() {
		return type;
	}

}