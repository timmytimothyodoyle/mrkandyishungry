package com.netcentric.brainery.yamldialog.classicui.editconfig;

import com.netcentric.brainery.yamldialog.api.model.NullAnyExporterItem;
import com.netcentric.brainery.yamldialog.api.model.yaml.Image;
import com.netcentric.brainery.yamldialog.common.editconfig.EditConfigBuilder;
import com.netcentric.brainery.yamldialog.common.model.AnyExportItem;

public class ClassicEditConfigBuilder implements EditConfigBuilder {

	@Override
	public boolean isValid() {
		System.out.println("ASDLKJASKLDJALSKD laksjd aksjd");
		return false;
	}

	@Override
	public AnyExportItem build() {
		System.out.println("387452iukhjasjdfhasd laksjd aksjd");
		return new NullAnyExporterItem();
	}

	@Override
	public void dropTarget(Image image) {
	}

}
