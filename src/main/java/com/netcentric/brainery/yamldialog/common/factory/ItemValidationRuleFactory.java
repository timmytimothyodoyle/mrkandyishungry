package com.netcentric.brainery.yamldialog.common.factory;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.netcentric.brainery.yamldialog.api.model.AnnotationItem;
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
import com.netcentric.brainery.yamldialog.api.validation.ItemValidationRule;
import com.netcentric.brainery.yamldialog.api.validation.ItemValidationRules;
import com.netcentric.brainery.yamldialog.api.validation.rule.ValidItemValidationRule;
import com.netcentric.brainery.yamldialog.common.validation.rule.NameValidationRule;
import com.netcentric.brainery.yamldialog.common.validation.rule.TitleValidationRule;
import com.netcentric.brainery.yamldialog.common.validation.rule.date.DateFormatValidationRule;
import com.netcentric.brainery.yamldialog.common.validation.rule.date.DateRangeValidationRule;
import com.netcentric.brainery.yamldialog.common.validation.rule.fragment.FragmentValidationRule;
import com.netcentric.brainery.yamldialog.common.validation.rule.number.NumberRangeValidationRule;
import com.netcentric.brainery.yamldialog.common.validation.rule.number.NumberValueValidationRule;
import com.netcentric.brainery.yamldialog.common.validation.rule.panel.PanelValidationRule;
import com.netcentric.brainery.yamldialog.common.validation.rule.pathfield.RootValidationRule;
import com.netcentric.brainery.yamldialog.common.validation.rule.radiogroup.RadiosValidationRule;
import com.netcentric.brainery.yamldialog.common.validation.rule.select.DefaultValidationRule;
import com.netcentric.brainery.yamldialog.common.validation.rule.tagfield.TypeValidationRule;
import com.netcentric.brainery.yamldialog.common.validation.rule.textarea.DimensionsValidationRule;
import com.netcentric.brainery.yamldialog.common.validation.rule.textfield.LengthValidationRule;

public class ItemValidationRuleFactory {

	private static List<Class<? extends ItemValidationRule<?>>> COMMONS = Arrays.asList(ValidItemValidationRule.class, NameValidationRule.class,
			TitleValidationRule.class);

	private static Map<Class<? extends AnnotationItem>, List<Class<? extends ItemValidationRule<?>>>> ADAPTERS;
	static {
		Map<Class<? extends AnnotationItem>, List<Class<? extends ItemValidationRule<?>>>> map = new HashMap<>();
		map.put(Text.class, Arrays.asList(ValidItemValidationRule.class));
		map.put(Radio.class, Arrays.asList(ValidItemValidationRule.class));
		map.put(Image.class, COMMONS);
		map.put(Panel.class, Arrays.asList(PanelValidationRule.class));
		map.put(Select.class, Arrays.asList(ValidItemValidationRule.class, NameValidationRule.class,
				TitleValidationRule.class, DefaultValidationRule.class));
		map.put(Switch.class, COMMONS);
		map.put(Option.class, Arrays.asList(ValidItemValidationRule.class));
		map.put(Dialog.class, Arrays.asList(ValidItemValidationRule.class, TitleValidationRule.class));
		map.put(Calendar.class, Arrays.asList(ValidItemValidationRule.class, NameValidationRule.class,
				TitleValidationRule.class, DateFormatValidationRule.class, DateRangeValidationRule.class));
		map.put(Fieldset.class, Arrays.asList(ValidItemValidationRule.class, TitleValidationRule.class));
		map.put(Fragment.class,
				Arrays.asList(ValidItemValidationRule.class, TitleValidationRule.class, FragmentValidationRule.class));
		map.put(Checkbox.class, COMMONS);
		map.put(Password.class, COMMONS);
		map.put(Tagfield.class, Arrays.asList(ValidItemValidationRule.class, NameValidationRule.class,
				TitleValidationRule.class, TypeValidationRule.class));
		map.put(TextArea.class, Arrays.asList(ValidItemValidationRule.class, NameValidationRule.class,
				TitleValidationRule.class, DimensionsValidationRule.class));
		map.put(Textfield.class, Arrays.asList(ValidItemValidationRule.class, NameValidationRule.class,
				TitleValidationRule.class, LengthValidationRule.class));
		map.put(Pathfield.class, Arrays.asList(ValidItemValidationRule.class, NameValidationRule.class,
				TitleValidationRule.class, RootValidationRule.class));
		map.put(Colorfield.class, COMMONS);
		map.put(Multifield.class, COMMONS);
		map.put(Radiogroup.class, Arrays.asList(ValidItemValidationRule.class, NameValidationRule.class,
				TitleValidationRule.class, RadiosValidationRule.class));
		map.put(Numberfield.class, Arrays.asList(ValidItemValidationRule.class, NameValidationRule.class,
				TitleValidationRule.class, NumberRangeValidationRule.class, NumberValueValidationRule.class));
		ADAPTERS = Collections.unmodifiableMap(map);
	}

	public static ItemValidationRules make(AnnotationItem item) {
		return new ItemValidationRules(ADAPTERS.get(item.getClass()));
	}
}
