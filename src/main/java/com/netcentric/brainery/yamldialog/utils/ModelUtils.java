package com.netcentric.brainery.yamldialog.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import com.netcentric.brainery.yamldialog.api.model.Item;
import com.netcentric.brainery.yamldialog.api.model.yaml.Calendar;
import com.netcentric.brainery.yamldialog.api.model.yaml.Checkbox;
import com.netcentric.brainery.yamldialog.api.model.yaml.Colorfield;
import com.netcentric.brainery.yamldialog.api.model.yaml.Dialog;
import com.netcentric.brainery.yamldialog.api.model.yaml.Fieldset;
import com.netcentric.brainery.yamldialog.api.model.yaml.Fragment;
import com.netcentric.brainery.yamldialog.api.model.yaml.Image;
import com.netcentric.brainery.yamldialog.api.model.yaml.Multifield;
import com.netcentric.brainery.yamldialog.api.model.yaml.Numberfield;
import com.netcentric.brainery.yamldialog.api.model.yaml.Option;
import com.netcentric.brainery.yamldialog.api.model.yaml.Panel;
import com.netcentric.brainery.yamldialog.api.model.yaml.Password;
import com.netcentric.brainery.yamldialog.api.model.yaml.Pathfield;
import com.netcentric.brainery.yamldialog.api.model.yaml.Radio;
import com.netcentric.brainery.yamldialog.api.model.yaml.Radiogroup;
import com.netcentric.brainery.yamldialog.api.model.yaml.Select;
import com.netcentric.brainery.yamldialog.api.model.yaml.Switch;
import com.netcentric.brainery.yamldialog.api.model.yaml.Tagfield;
import com.netcentric.brainery.yamldialog.api.model.yaml.Text;
import com.netcentric.brainery.yamldialog.api.model.yaml.TextArea;
import com.netcentric.brainery.yamldialog.api.model.yaml.Textfield;

public class ModelUtils {

	public static Map<String, Class<? extends Item>> modelClassMap;
	static {
		modelClassMap = new HashMap<String, Class<? extends Item>>();
		modelClassMap.put("text", Text.class);
		modelClassMap.put("item", Option.class);
		modelClassMap.put("image", Image.class);
		modelClassMap.put("panel", Panel.class);
		modelClassMap.put("radio", Radio.class);
		modelClassMap.put("switch", Switch.class);
		modelClassMap.put("select", Select.class);
		modelClassMap.put("dialog", Dialog.class);
		modelClassMap.put("fragment", Fragment.class);
		modelClassMap.put("fieldset", Fieldset.class);
		modelClassMap.put("password", Password.class);
		modelClassMap.put("tagfield", Tagfield.class);
		modelClassMap.put("calendar", Calendar.class);
		modelClassMap.put("checkbox", Checkbox.class);
		modelClassMap.put("textarea", TextArea.class);
		modelClassMap.put("textfield", Textfield.class);
		modelClassMap.put("pathfield", Pathfield.class);
		modelClassMap.put("colorfield", Colorfield.class);
		modelClassMap.put("radiogroup", Radiogroup.class);
		modelClassMap.put("multifield", Multifield.class);
		modelClassMap.put("numberfield", Numberfield.class);
	}

	public static String adapt(Class<? extends Item> clazz) {
		return modelClassMap.entrySet().stream().filter(entry -> entry.getValue().equals(clazz)).map(Map.Entry::getKey)
				.collect(Collectors.joining());
	}
}
