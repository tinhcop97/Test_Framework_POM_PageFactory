package helpers;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertiesHelpers {
    private static Properties properties;
    private static String linkFile;
    private static FileInputStream file;
    private static String relPropertiesFilePathDefault = "src/test/resources/config/config.properties";

    public static String getCurrentDir() {
        String current = System.getProperty("user.dir") + "/";
        return current;
    }

    public static String getValue(String key) {
        String keyval = null;
        try {
            if (file == null) {
                properties = new Properties();
                linkFile = PropertiesHelpers.getCurrentDir() + relPropertiesFilePathDefault;
                file = new FileInputStream(linkFile);
                properties.load(file);
                file.close();
            }
            // Lấy giá trị từ file đã Set
            keyval = properties.getProperty(key);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return keyval;
    }

}
