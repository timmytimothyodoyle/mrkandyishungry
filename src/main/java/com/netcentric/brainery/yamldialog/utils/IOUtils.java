package com.netcentric.brainery.yamldialog.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Optional;

public class IOUtils {

	public static boolean save(String file, String content) {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
			bw.write(content);
			return true;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}

	public static String open(String file) throws IOException {
		return new String(Files.readAllBytes(Paths.get(file)));
	}

	public static String open(URL url) throws IOException {
		String content = Utils.EMPTY_STR;
		String inputLine;
		BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
		while ((inputLine = in.readLine()) != null)
			content += inputLine;
		in.close();
		return content;
	}

	public static String read(String path) throws IOException {
		return Optional.of(new String(Files.readAllBytes(Paths.get(path)))).orElse(Utils.EMPTY_STR);
	}
}