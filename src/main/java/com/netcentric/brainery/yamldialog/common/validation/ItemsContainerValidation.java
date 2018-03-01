package com.netcentric.brainery.yamldialog.common.validation;

import java.util.List;

import com.netcentric.brainery.yamldialog.api.model.AnnotationItem;
import com.netcentric.brainery.yamldialog.api.validation.ItemValidation;
import com.netcentric.brainery.yamldialog.api.validation.model.Conflicts;
import com.netcentric.brainery.yamldialog.common.factory.ItemValidationFactory;
import com.netcentric.brainery.yamldialog.common.factory.ItemValidationRuleFactory;

public abstract class ItemsContainerValidation<E extends AnnotationItem> implements ItemValidation<E> {

	@Override
	public Conflicts validate(E annotationItem) {
		// apply the existing validation rules to the item
		Conflicts conflitcs = ItemValidationRuleFactory.make(annotationItem).apply(annotationItem);
		// validate each item
		for (AnnotationItem item : getItems(annotationItem)) {
			ItemValidation<AnnotationItem> validation = ItemValidationFactory.make(item);
			if (validation.isValid()) {
				conflitcs.add(validation.validate(item).list());
			} else {
				conflitcs.add(ItemValidationRuleFactory.make(item).apply(item).list());
			}
		}
		return conflitcs;
	}

	@Override
	public boolean isValid() {
		return true;
	}

	protected abstract List<AnnotationItem> getItems(E annotationItem);

}