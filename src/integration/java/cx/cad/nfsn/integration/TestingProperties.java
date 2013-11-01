package cx.cad.nfsn.integration;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class TestingProperties extends Properties {
    public static TestingProperties loadTestingProperties() throws IOException {
        TestingProperties properties = new TestingProperties();
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream in = classLoader.getResourceAsStream("testing.properties");
        properties.load(in);
        return properties;
    }
}
