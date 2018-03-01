package com.netcentric.brainery.yamldialog.api.validation;

import com.netcentric.brainery.yamldialog.api.model.Item;
import com.netcentric.brainery.yamldialog.api.validation.model.Conflicts;

public class NullItemValidation implements ItemValidation<Item> {

	@Override
	public boolean isValid() {
		return false;
	}

	@Override
	public Conflicts validate(Item item) {
		return new Conflicts();
	}

}
