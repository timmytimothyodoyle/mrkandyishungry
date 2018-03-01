package com.netcentric.brainery.yamldialog.common.editconfig;

import com.netcentric.brainery.yamldialog.api.model.NullAnyExporterItem;
import com.netcentric.brainery.yamldialog.api.model.yaml.Image;
import com.netcentric.brainery.yamldialog.common.model.AnyExportItem;

public class NullEditConfigBuilder implements EditConfigBuilder {

	@Override
	public boolean isValid() {
		return false;
	}

	@Override
	public AnyExportItem build() {
		return new NullAnyExporterItem();
	}

	@Override
	public void dropTarget(Image image) {
	}

}
