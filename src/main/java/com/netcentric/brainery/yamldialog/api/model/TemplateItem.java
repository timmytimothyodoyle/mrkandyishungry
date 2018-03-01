package com.netcentric.brainery.yamldialog.api.model;

import static com.netcentric.brainery.yamldialog.utils.Utils.isEmpty;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;
import java.util.regex.Pattern;

import com.netcentric.brainery.yamldialog.common.TemplateKey;
import com.netcentric.brainery.yamldialog.utils.IOUtils;
import com.netcentric.brainery.yamldialog.utils.Utils;

public class TemplateItem implements ExportItem {

	protected String template;

	protected TemplateKey key;

	private Map<String, String> values;

	public TemplateItem(String path, TemplateKey key) {
		try {
			this.key = key;
			if (!isEmpty(path))
				this.template = IOUtils.read(path);
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.values = new HashMap<String, String>();
	}

	public void setValue(String key, String value) {
		this.values.put(key, value);
	}

	public void setBooleanValue(String key, Boolean value) {
		String result = value != null ? value.toString() : null;
		this.values.put(key, result);
	}

	public void setNumericValue(String key, Number value) {
		String result = value != null ? value.toString() : null;
		this.values.put(key, result);
	}

	public String instanciate() {
		for (String key : values.keySet()) {
			String value = values.get(key);
			String pattern = Pattern.quote("${" + key + "}");
			if (value != null) {
				if (key.equals("items") || key.equals("options") || key.equals("radios")) {
					value = alacazzaam(value, Utils.blanksbefore(template, template.indexOf("${" + key + "}")));
				}
				template = template.replaceAll(pattern, value);
			} else {
				template = template.replaceAll(".*" + pattern + ".*(\r?\n|\r)?", "");
			}
		}
		return template;
	}

	private String alacazzaam(String value, int margin) {
		StringJoiner joiner = new StringJoiner(Utils.BREAK_LINE);
		String[] lines = Utils.breaklines(value);
		for (int i = 0; i < lines.length; i++) {
			joiner.add(Utils.blanks(i > 0 ? margin : 0) + lines[i]);
		}
		return joiner.toString();
	}

	@Override
	public boolean isValid() {
		return key != null && template != null;
	}

	@Override
	public TemplateKey getKey() {
		return key;
	}
}
