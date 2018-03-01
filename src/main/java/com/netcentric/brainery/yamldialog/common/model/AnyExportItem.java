package com.netcentric.brainery.yamldialog.common.model;

import com.netcentric.brainery.yamldialog.api.model.ExportItem;
import com.netcentric.brainery.yamldialog.common.TemplateKey;
import com.netcentric.brainery.yamldialog.utils.Utils;

public class AnyExportItem implements ExportItem {

	private String item;

	private TemplateKey key;

	public AnyExportItem(String item, TemplateKey key) {
		this.key = key;
		this.item = item;
	}

	@Override
	public boolean isValid() {
		return !Utils.isEmpty(item) && key != null;
	}

	public String getItem() {
		return item;
	}

	@Override
	public String toString() {
		return item;
	}

	@Override
	public TemplateKey getKey() {
		return key;
	}

}
