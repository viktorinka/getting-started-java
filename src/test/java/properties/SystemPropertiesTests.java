package properties;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Tag("one_property")
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
    void simpleProperty4Test() {
        String browserName = System.getProperty("browser", "mozilla");
        System.out.println(browserName);
    }
    @Test
    @Disabled
    void skipTest() {
        assertTrue(false);
    }

    @Test
    void negativeTest() {
        assertTrue(false);
    }
}
