package com.netcentric.brainery.yamldialog.common;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

import com.netcentric.brainery.yamldialog.api.model.DialogType;
import com.netcentric.brainery.yamldialog.api.model.NullTemplateItem;
import com.netcentric.brainery.yamldialog.api.model.TemplateItem;
import com.netcentric.brainery.yamldialog.api.model.AnnotationType;
import com.netcentric.brainery.yamldialog.utils.Utils;

public class TemplateItemProvider {

	private static final String ROOT = "src/main/resources/com/netcentric/brainery/yamldialog/";

	protected static final String EXTENSION = ".template";

	private static final Map<TemplateKey, String> TEMPLATES;
	static {
		Map<TemplateKey, String> map = new HashMap<>();
		try (Stream<Path> paths = Files.walk(Paths.get(ROOT))) {
			paths.filter(Files::isRegularFile).forEach(path -> putTemplate(path, map));
		} catch (IOException e) {
			e.printStackTrace();
		}
		TEMPLATES = Collections.unmodifiableMap(map);
	}

	public static TemplateItem get(final AnnotationType template) {
		return get(new TemplateKey(DialogType.TOUCHUI_CORAL, template));
	}

	public static TemplateItem get(final TemplateKey key) {
		String path = TEMPLATES.get(key);
		if (!Utils.isEmpty(path)) {
			return new TemplateItem(path, key);
		}
		return new NullTemplateItem();
	}

	public static TemplateItem get(final DialogType type, final AnnotationType template) {
		return get(new TemplateKey(type, template));
	}

	private static void putTemplate(final Path path, final Map<TemplateKey, String> map) {
		String item = Utils.remove(path.getFileName().toString(), ROOT, EXTENSION);
		String value = path.toString();
		String type = path.toString().replace(ROOT, Utils.EMPTY_STR).split("/")[0];
		map.put(new TemplateKey(Utils.get(type, DialogType.class), Utils.get(item, AnnotationType.class)), value);
	}

}