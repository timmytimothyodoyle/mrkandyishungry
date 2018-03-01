package com.netcentric.brainery.yamldialog.api.adapter;

import com.netcentric.brainery.yamldialog.api.model.DialogType;
import com.netcentric.brainery.yamldialog.api.model.Item;
import com.netcentric.brainery.yamldialog.common.model.AnyExportItem;

public interface AnyExportItemAdapter<E extends Item> extends Item {

	public AnyExportItem adapt(E param, DialogType type);
}
