package com.netcentric.brainery.yamldialog.common.factory;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import com.netcentric.brainery.yamldialog.api.model.AnnotationItem;
import com.netcentric.brainery.yamldialog.api.model.Item;
import com.netcentric.brainery.yamldialog.api.model.yaml.Fieldset;
import com.netcentric.brainery.yamldialog.api.model.yaml.Multifield;
import com.netcentric.brainery.yamldialog.api.model.yaml.Radiogroup;
import com.netcentric.brainery.yamldialog.api.model.yaml.Select;
import com.netcentric.brainery.yamldialog.api.validation.ItemValidation;
import com.netcentric.brainery.yamldialog.api.validation.NullItemValidation;
import com.netcentric.brainery.yamldialog.common.validation.FieldsetValidation;
import com.netcentric.brainery.yamldialog.common.validation.MultifieldValidation;
import com.netcentric.brainery.yamldialog.common.validation.RadiogroupValidation;
import com.netcentric.brainery.yamldialog.common.validation.SelectValidation;

public class ItemValidationFactory {

	private static Map<Class<? extends Item>, Class<? extends ItemValidation<?>>> ADAPTERS;
	static {
		Map<Class<? extends Item>, Class<? extends ItemValidation<?>>> map = new HashMap<>();
		map.put(Select.class, SelectValidation.class);
		map.put(Fieldset.class, FieldsetValidation.class);
		map.put(Radiogroup.class, RadiogroupValidation.class);
		map.put(Multifield.class, MultifieldValidation.class);
		ADAPTERS = Collections.unmodifiableMap(map);
	}

	@SuppressWarnings("unchecked")
	public static <E extends AnnotationItem, T extends ItemValidation<E>> T make(E item) {
		if (ADAPTERS.containsKey(item.getClass())) {
			try {
				return (T) ADAPTERS.get(item.getClass()).newInstance();
			} catch (InstantiationException | IllegalAccessException e) {
				System.out.println("ACA VIEJAAAAAA UNO MAS");
			}
		}
		return (T) new NullItemValidation();
	}
}
