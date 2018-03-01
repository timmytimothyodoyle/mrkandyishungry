package com.netcentric.brainery.yamldialog.common.model;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

import com.netcentric.brainery.yamldialog.api.model.Item;
import com.netcentric.brainery.yamldialog.utils.Utils;

public class AnyExportItems implements Item {

	private List<AnyExportItem> items;

	public AnyExportItems() {
		items = new ArrayList<AnyExportItem>();
	}

	public void add(AnyExportItem item) {
		if (item.isValid())
			items.add(item);
	}

	public boolean isValid() {
		return items != null && !items.isEmpty();
	}

	public int size() {
		return isValid() ? items.size() : 0;
	}

	@Override
	public String toString() {
		StringJoiner joiner = new StringJoiner(Utils.BREAK_LINE);
		for (AnyExportItem item : items) {
			joiner.add(item.getItem());
		}
		return joiner.toString();
	}

}
