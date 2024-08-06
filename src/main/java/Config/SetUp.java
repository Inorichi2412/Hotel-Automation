package Config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class SetUp {

    private Properties properties;

    public SetUp() {
        properties = new Properties();
        try {
            FileInputStream configStream = new FileInputStream("src/main/resources/config.properties");
            properties.load(configStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getUrl() {
        return properties.getProperty("url");
    }
}
