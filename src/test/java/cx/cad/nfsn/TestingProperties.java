package cx.cad.nfsn;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class TestingProperties extends Properties {
    public static TestingProperties loadTestingProperties() throws IOException {
        TestingProperties properties = new TestingProperties();
        InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream("testing.properties");
        properties.load(in);
        return properties;
    }
}
