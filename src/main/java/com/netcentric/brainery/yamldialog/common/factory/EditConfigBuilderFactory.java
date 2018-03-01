package com.netcentric.brainery.yamldialog.common.factory;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import com.netcentric.brainery.yamldialog.api.model.DialogType;
import com.netcentric.brainery.yamldialog.classicui.editconfig.ClassicEditConfigBuilder;
import com.netcentric.brainery.yamldialog.common.editconfig.EditConfigBuilder;
import com.netcentric.brainery.yamldialog.common.editconfig.NullEditConfigBuilder;
import com.netcentric.brainery.yamldialog.touchui.coral.editconfig.CoralEditConfigBuilder;

public class EditConfigBuilderFactory {

	private static Map<DialogType, EditConfigBuilder> ADAPTERS;
	static {
		Map<DialogType, EditConfigBuilder> map = new HashMap<>();
		map.put(DialogType.CLASSICUI, new ClassicEditConfigBuilder());
		map.put(DialogType.TOUCHUI_CORAL, new CoralEditConfigBuilder());
		ADAPTERS = Collections.unmodifiableMap(map);
	}

	public static EditConfigBuilder make(DialogType type) {
		return ADAPTERS.containsKey(type) ? ADAPTERS.get(type) : new NullEditConfigBuilder();
	}
}
