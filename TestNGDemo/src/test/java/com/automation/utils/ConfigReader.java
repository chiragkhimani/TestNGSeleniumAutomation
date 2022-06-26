package com.automation.utils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Properties;

public class ConfigReader {
	static Properties prop;

	public static void setUpConfig() {
		FileReader reader;
		try {
			reader = new FileReader("src//test//resources//config//config.properties");
			prop = new Properties();
			prop.load(reader);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static String getConfigValue(String key) {
		return prop.getProperty(key);
	}

}
