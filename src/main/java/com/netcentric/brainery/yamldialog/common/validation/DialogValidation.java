package com.netcentric.brainery.yamldialog.common.validation;

import static com.netcentric.brainery.yamldialog.common.factory.ItemValidationRuleFactory.make;

import com.netcentric.brainery.yamldialog.api.model.yaml.Dialog;
import com.netcentric.brainery.yamldialog.api.model.yaml.Panel;
import com.netcentric.brainery.yamldialog.api.validation.ItemValidation;
import com.netcentric.brainery.yamldialog.api.validation.model.Conflicts;

public class DialogValidation implements ItemValidation<Dialog> {

	private PanelValidation panelValidation = new PanelValidation();

	@Override
	public Conflicts validate(Dialog item) {
		// apply the existing validation rules to the dialog
		Conflicts conflicts = make(item).apply(item);
		conflicts.add(item.getConflicts());
		// validate each panel
		if(item.isValid()) {
			for (Panel panel : item.items) {
				conflicts.add(panelValidation.validate(panel).list());
			}
		}
		return conflicts;
	}

	@Override
	public boolean isValid() {
		return panelValidation != null;
	}

}
