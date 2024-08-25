package utils;

import java.time.Duration;
import java.util.Properties;

public class ConfigReader {
    Properties properties;
    public ConfigReader() {
        properties = new Properties();
        try {
            properties.load(getClass().getClassLoader().getResourceAsStream("config.properties"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public String getUrl() {
        return properties.getProperty("url");
    }

    public String getUrlAdmin() {
        return properties.getProperty("urlAdmin");
    }
    public Duration getTimeOut() {
        return Duration.ofSeconds(
                Long.parseLong(
                        properties.getProperty("timeout")
                )
        );
    }
}
