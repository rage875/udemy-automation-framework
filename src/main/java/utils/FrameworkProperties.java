package utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class FrameworkProperties {
    private InputStream inputStream;

    public String getProperty(String key) {
        String result = "";

        try {
            Properties properties = null;

            properties = new Properties();
            String propFileName = Constants.PROP_FILE_NAME;
            inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);

            if(inputStream != null) {
                properties.load(inputStream);
            } else {
                throw new FileNotFoundException(String.format("[ERROR]: Property file %s not found", propFileName));
            }

            result = properties.getProperty(key);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }
}
