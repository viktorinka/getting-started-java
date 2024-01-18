package properties;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class SystemPropertiesTests {
    @Test
    void simplePropertyTest() {
        String browserName = System.getProperty("browser");
        System.out.println(browserName); // null
    }

    @Test
    void simpleProperty1Test() {
        System.setProperty("browser", "opera");
        String browserName = System.getProperty("browser");
        System.out.println(browserName); // opera
    }

    @Test
    void simpleProperty2Test() {
        String browserName = System.getProperty("browser", "mozilla");
        System.out.println(browserName); // mozilla
    }

    @Test
    void simpleProperty3Test() {
        System.setProperty("browser", "opera");
        String browserName = System.getProperty("browser", "mozilla");
        System.out.println(browserName); // opera
    }

    @Test
    @Tag("one_property")
    void simpleProperty4Test() {
        String browserName = System.getProperty("browser", "mozilla");
        System.out.println(browserName);

        // gradle clean one_property_test
        // mozilla

        // gradle clean one_property_test -Dbrowser=safari
        // safari

    }
}
