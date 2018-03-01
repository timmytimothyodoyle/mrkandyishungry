package com.netcentric.brainery.yamldialog.platform.web.ace;

import java.util.ArrayList;
import java.util.List;

import com.netcentric.brainery.yamldialog.api.model.Item;

public class AceDialog implements Item {

	private String title;

	private String group;

	private String description;

	private List<AcePanel> panels;

	public AceDialog(String title, String group, String description) {
		this.title = title;
		this.group = group;
		this.description = description;
		this.panels = new ArrayList<>();
	}

	public void addPanel(AcePanel panel) {
		if (panel.isValid()) {
			panels.add(panel);
		}
	}

	public String getTitle() {
		return title;
	}

	public String getGroup() {
		return group;
	}

	public String getDescription() {
		return description;
	}

	public List<AcePanel> getPanels() {
		return panels;
	}

	@Override
	public boolean isValid() {
		return title != null && panels != null;
	}
}
