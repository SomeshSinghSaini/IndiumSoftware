package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigProperty {
	
	public static String getPropertyValue(String key) throws IOException {
		String value = "";
		FileInputStream propertyFile = new FileInputStream("./src/test/resources/prop/config.property");
		Properties prop = new Properties();
		prop.load(propertyFile);
		value = prop.getProperty(key);
		return value;
	}

}
