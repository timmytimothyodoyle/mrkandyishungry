package com.netcentric.brainery.yamldialog.common.editconfig;

import com.netcentric.brainery.yamldialog.api.model.Item;
import com.netcentric.brainery.yamldialog.api.model.yaml.Image;
import com.netcentric.brainery.yamldialog.common.model.AnyExportItem;

public interface EditConfigBuilder extends Item {

	public AnyExportItem build();

	public void dropTarget(Image image);
}
