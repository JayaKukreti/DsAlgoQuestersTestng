package dsAlgoUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private static Properties prop = null;
    private static String browserType = null;

    // Singleton pattern to load properties only once
    public static Properties initializeProp() {
        if (prop == null) {
            prop = new Properties();
            try {
                // Load testdata.properties
                FileInputStream testDataFile = new FileInputStream(
                        System.getProperty("user.dir") + "/src/test/resources/dsAlgoProperties/testdata.properties");
                prop.load(testDataFile);
               testDataFile.close();

                // Load Config.properties
                FileInputStream configFile = new FileInputStream(
                        System.getProperty("user.dir") + "/src/test/resources/dsAlgoProperties/Config.properties");
                prop.load(configFile);
                configFile.close();
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException("Failed to load configuration files.");
            }
        }
        return prop;
    }

	public static void setBrowserType(String browser) {
		browserType = browser;
	}

	public static String getBrowserType() {
		if (browserType != null) {
			return browserType;
		} else {
			throw new RuntimeException(
					"Browser not specified. Please provide it in the testng.xml or as a Maven parameter.");
		}
	}
}
