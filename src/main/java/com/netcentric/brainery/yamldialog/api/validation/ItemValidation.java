package com.netcentric.brainery.yamldialog.api.validation;

import com.netcentric.brainery.yamldialog.api.model.Item;
import com.netcentric.brainery.yamldialog.api.validation.model.Conflicts;

public interface ItemValidation<E extends Item> extends Item {

	public Conflicts validate(E item);
}
