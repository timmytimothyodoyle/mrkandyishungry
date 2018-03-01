package com.netcentric.brainery.yamldialog.api.adapter;

import com.netcentric.brainery.yamldialog.api.model.DialogType;
import com.netcentric.brainery.yamldialog.api.model.Item;
import com.netcentric.brainery.yamldialog.api.model.NullAnyExporterItem;
import com.netcentric.brainery.yamldialog.common.model.AnyExportItem;

public class NullAnyExportItemAdapter implements AnyExportItemAdapter<Item> {

	@Override
	public boolean isValid() {
		return false;
	}

	@Override
	public AnyExportItem adapt(Item param, DialogType type) {
		return new NullAnyExporterItem();
	}

}
