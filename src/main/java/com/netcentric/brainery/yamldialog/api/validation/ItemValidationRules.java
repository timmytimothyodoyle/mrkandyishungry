package com.netcentric.brainery.yamldialog.api.validation;

import java.util.ArrayList;
import java.util.List;

import com.netcentric.brainery.yamldialog.api.model.AnnotationItem;
import com.netcentric.brainery.yamldialog.api.validation.model.Conflicts;

public class ItemValidationRules {

	private List<ItemValidationRule<AnnotationItem>> rules;

	public ItemValidationRules() {
		rules = new ArrayList<>();
	}

	@SuppressWarnings("unchecked")
	public ItemValidationRules(List<Class<? extends ItemValidationRule<?>>> list) {
		this();
		if (list != null) {
			for (Class<? extends ItemValidationRule<?>> item : list) {
				try {
					rules.add(((ItemValidationRule<AnnotationItem>) item.newInstance()));
				} catch (InstantiationException | IllegalAccessException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public ItemValidationRules expand(ItemValidationRules rules) {
		ItemValidationRules expanded = new ItemValidationRules();
		expanded.add(list());
		expanded.add(rules.list());
		return expanded;
	}

	private void add(List<ItemValidationRule<AnnotationItem>> items) {
		if (items != null) {
			rules.addAll(items);
		}
	}

	public Conflicts apply(AnnotationItem item) {
		Conflicts conflicts = new Conflicts();
		for (ItemValidationRule<AnnotationItem> rule : list()) {
			ValidationResult validation = rule.pass(item);
			if (!validation.isValid()) {
				validation.getConflict().ifPresent(conflict -> {
					item.conflict(conflict);
					conflicts.add(conflict);
				});
			}
		}
		return conflicts;
	}

	private List<ItemValidationRule<AnnotationItem>> list() {
		return rules;
	}
}