package com.netcentric.brainery.yamldialog.common.factory;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import com.netcentric.brainery.yamldialog.api.adapter.AnyExportItemAdapter;
import com.netcentric.brainery.yamldialog.api.adapter.NullAnyExportItemAdapter;
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
import com.netcentric.brainery.yamldialog.common.adapter.CalendarAdapter;
import com.netcentric.brainery.yamldialog.common.adapter.CheckboxAdapter;
import com.netcentric.brainery.yamldialog.common.adapter.ColorfieldAdapter;
import com.netcentric.brainery.yamldialog.common.adapter.DialogAdapter;
import com.netcentric.brainery.yamldialog.common.adapter.FieldsetAdapter;
import com.netcentric.brainery.yamldialog.common.adapter.FragmentAdapter;
import com.netcentric.brainery.yamldialog.common.adapter.ImageAdapter;
import com.netcentric.brainery.yamldialog.common.adapter.MultifieldAdapter;
import com.netcentric.brainery.yamldialog.common.adapter.NumberfieldAdapter;
import com.netcentric.brainery.yamldialog.common.adapter.OptionAdapter;
import com.netcentric.brainery.yamldialog.common.adapter.PanelAdapter;
import com.netcentric.brainery.yamldialog.common.adapter.PasswordAdapter;
import com.netcentric.brainery.yamldialog.common.adapter.PathfieldAdapter;
import com.netcentric.brainery.yamldialog.common.adapter.RadioAdapter;
import com.netcentric.brainery.yamldialog.common.adapter.RadiogroupAdapter;
import com.netcentric.brainery.yamldialog.common.adapter.SelectAdapter;
import com.netcentric.brainery.yamldialog.common.adapter.SwitchAdapter;
import com.netcentric.brainery.yamldialog.common.adapter.TagfieldAdapter;
import com.netcentric.brainery.yamldialog.common.adapter.TextAdapter;
import com.netcentric.brainery.yamldialog.common.adapter.TextareaAdapter;
import com.netcentric.brainery.yamldialog.common.adapter.TextfieldAdapter;

public class ItemAdapterFactory {

	private static Map<Class<? extends Item>, Class<? extends AnyExportItemAdapter<?>>> ADAPTERS;
	static {
		Map<Class<? extends Item>, Class<? extends AnyExportItemAdapter<?>>> map = new HashMap<>();
		map.put(Text.class, TextAdapter.class);
		map.put(Radio.class, RadioAdapter.class);
		map.put(Image.class, ImageAdapter.class);
		map.put(Panel.class, PanelAdapter.class);
		map.put(Option.class, OptionAdapter.class);
		map.put(Switch.class, SwitchAdapter.class);
		map.put(Select.class, SelectAdapter.class);
		map.put(Dialog.class, DialogAdapter.class);
		map.put(Calendar.class, CalendarAdapter.class);
		map.put(Password.class, PasswordAdapter.class);
		map.put(Fragment.class, FragmentAdapter.class);
		map.put(Checkbox.class, CheckboxAdapter.class);
		map.put(Tagfield.class, TagfieldAdapter.class);
		map.put(Calendar.class, CalendarAdapter.class);
		map.put(TextArea.class, TextareaAdapter.class);
		map.put(Fieldset.class, FieldsetAdapter.class);
		map.put(Textfield.class, TextfieldAdapter.class);
		map.put(Pathfield.class, PathfieldAdapter.class);
		map.put(Multifield.class, MultifieldAdapter.class);
		map.put(Radiogroup.class, RadiogroupAdapter.class);
		map.put(Colorfield.class, ColorfieldAdapter.class);
		map.put(Numberfield.class, NumberfieldAdapter.class);
		ADAPTERS = Collections.unmodifiableMap(map);
	}

	@SuppressWarnings("unchecked")
	public static <E extends Item, T extends AnyExportItemAdapter<Item>> T make(E type) {
		if (ADAPTERS.containsKey(type.getClass())) {
			try {
				return (T) ADAPTERS.get(type.getClass()).newInstance();
			} catch (InstantiationException | IllegalAccessException e) {
				System.out.println("ACA VIEJAAAAAA");
			}
		}
		return (T) new NullAnyExportItemAdapter();
	}
}
