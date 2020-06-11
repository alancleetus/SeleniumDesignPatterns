package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {

	protected Properties properties;

	public ConfigReader() {
		FileInputStream inStream;
		try {
			inStream = new FileInputStream(new File("./Configuration/Config.property"));
			properties = new Properties();
			properties.load(inStream);

		} catch (Exception e) {
			System.out.println("Error Reading Config File");
			e.printStackTrace();
		}
	}

	// getting drivers
	public String getChromePath() {
		return properties.getProperty("chrome");
	}

	public String getEdgePath() {
		return properties.getProperty("msedge");
	}

	public String getFirefoxPath() {
		return properties.getProperty("firefox");
	}

	// getting urls
	public String getBaseUrl() {
		return properties.getProperty("baseUrl");
	}
}
