package com.netcentric.brainery.yamldialog.utils;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.StringJoiner;

public class Utils {

	public static final char BLANK_CHAR = ' ';
	public static final String BLANK_STR = " ";
	public static final String EMPTY_STR = "";
	public static final String SEPARATOR = "|-_-|";
	public static final String BREAK_LINE = "\n";

	public static String randomize(String base) {
		return base + "_" + Math.round(Math.random() * 1000);
	}

	public static boolean isNumeric(String str) {
		return str == null ? false : str.matches("-?\\d+(\\.\\d+)?");
	}

	public static Long number(String str) {
		return str == null || !isNumeric(str) ? Long.MIN_VALUE : Long.valueOf(str);
	}

	public static String[] breaklines(String param) {
		return param != null && !param.isEmpty() ? param.split("\\r?\\n") : new String[] {};
	}

	public static boolean isEmpty(String line) {
		if (line == null || line.isEmpty() || line.replace(BLANK_STR, EMPTY_STR).isEmpty()) {
			return true;
		}
		return false;
	}

	public static String blanks(int margin) {
		String str = EMPTY_STR;
		for (int i = 0; i < margin; i++) {
			str += BLANK_STR;
		}
		return str;
	}

	public static int blanksbefore(String template, int index) {
		int count = 0;
		for (int i = index - 1; i >= 0; i--) {
			if (BLANK_CHAR == template.charAt(i)) {
				count++;
				continue;
			}
			break;
		}
		return count;
	}

	public static String remove(String item, String... keys) {
		for (String key : keys) {
			item = item.replaceAll(key, EMPTY_STR);
		}
		return item;
	}

	public static boolean empty(Collection<?> collection) {
		return (collection == null || collection.isEmpty());
	}

	public static String format(String code) {
		if (code == null)
			return EMPTY_STR;
		StringJoiner formatted = new StringJoiner(BREAK_LINE);
		String[] lines = Utils.breaklines(code);
		for (String line : lines) {
			if (!isEmpty(line)) {
				formatted.add(line);
			}
		}
		return formatted.toString();
	}

	// TYPE UTILS

	public static <E> List<E> safe(List<E> other, Class<E> clazz) {
		return other == null ? Collections.emptyList() : other;
	}

	public static boolean equals(String type, Enum<?> enumeration) {
		if (type != null && enumeration != null && type.equals(enumeration.toString()))
			return true;
		return false;
	}

	public static <E extends Enum<E>> boolean contains(String value, Class<E> enumClass) {
		for (E e : enumClass.getEnumConstants()) {
			if (e.toString().equals(value)) {
				return true;
			}
		}
		return false;
	}

	public static <E extends Enum<E>> E get(String value, Class<E> enumClass) {
		for (E e : enumClass.getEnumConstants()) {
			if (e.toString().equals(value)) {
				return e;
			}
		}
		return null;
	}

	public static <E extends Enum<E>> String list(Class<E> enumClass) {
		StringJoiner joiner = new StringJoiner(",");
		for (E e : enumClass.getEnumConstants()) {
			joiner.add(e.toString());
		}
		return joiner.toString();
	}
}
