package com.netcentric.brainery.yamldialog.platform.web.adapter.open;

import java.util.StringTokenizer;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.netcentric.brainery.yamldialog.api.adapter.AnyAdapter;
import com.netcentric.brainery.yamldialog.platform.web.exception.YdbProjectException;
import com.netcentric.brainery.yamldialog.utils.Utils;

/**
 * Esta clase es un pedazo de mierda, hay que hacerla de nuevo y repensar todo,
 * es mas tira todo el proyecto a la basura y hacelo de nuevo asi pasa los
 * standares de la ISOCHOTA
 * 
 * @author sebastianvenere
 *
 */
public class YamlYdbProjectJSONAdapter implements AnyAdapter<JsonObject, String> {

	@Override
	public JsonObject adapt(String code) {
		//
		if (code == null || code.isEmpty()) {
			throw new YdbProjectException();
		}
		//
		String[] lines = Utils.breaklines(code);

		JsonObject dialog = getDialogJson(lines);
		JsonArray editors = new JsonArray();
		int start = dialog.get("end").getAsInt() + 1;
		while (true) {
			JsonObject panel = getPanelJson(lines, start);
			if (panel == null)
				break;
			else
				start = panel.get("end").getAsInt();
			editors.add(panel);
		}
		dialog.add("editors", editors);
		return dialog;
	}

	private JsonObject getPanelJson(String[] lines, int start) {
		String items = Utils.BLANK_STR;
		boolean store = false;
		JsonObject panel = null;
		int i = start;
		for (; i < lines.length; i++) {
			if (Utils.isEmpty(lines[i]))
				continue;
			StringTokenizer tokenizer = new StringTokenizer(lines[i], Utils.BLANK_STR);
			String token = tokenizer.nextToken();
			if (token.equals("-")) {
				String element = tokenizer.nextToken();
				if (element.equals("!panel")) {
					if (panel == null) {
						panel = new JsonObject();
						panel.addProperty("start", i);
						continue;
					}
					break;
				}
			}
			if (panel != null) {
				if (store) {
					items += lines[i] + Utils.BREAK_LINE;
					continue;
				}
				if (token.equals("name:")) {
					String name = tokenizer.nextToken(Utils.EMPTY_STR);
					panel.addProperty("name", name.substring(name.indexOf("'")).replaceAll("'", Utils.EMPTY_STR));
				} else if (token.equals("title:")) {
					String title = tokenizer.nextToken(Utils.EMPTY_STR);
					panel.addProperty("title", title.substring(title.indexOf("'")).replaceAll("'", Utils.EMPTY_STR));
				} else if (token.equals("items:")) {
					store = true;
				}
			}
		}
		if (panel != null) {
			panel.addProperty("end", i);
			panel.addProperty("items", items);
		}
		return panel;
	}

	private JsonObject getDialogJson(String[] lines) {
		JsonObject dialog = new JsonObject();
		for (int i = 0; i < lines.length; i++) {
			StringTokenizer tokenizer = new StringTokenizer(lines[i], Utils.BLANK_STR);
			String token = tokenizer.nextToken();
			if (token.equals("-")) {
				String element = tokenizer.nextToken();
				if (element.equals("!dialog")) {
					dialog.addProperty("start", i);
				}
			} else if (token.equals("title:")) {
				String title = tokenizer.nextToken(Utils.EMPTY_STR);
				title = title.substring(title.indexOf("'")).replaceAll("'", Utils.EMPTY_STR);
				dialog.addProperty("title", title);
			} else if (token.equals("group:")) {
				String group = tokenizer.nextToken(Utils.EMPTY_STR);
				group = group.substring(group.indexOf("'")).replaceAll("'", Utils.EMPTY_STR);
				dialog.addProperty("group", group);
			} else if (token.equals("items:")) {
				dialog.addProperty("end", i);
				break;
			}
		}
		return dialog;
	}

}
