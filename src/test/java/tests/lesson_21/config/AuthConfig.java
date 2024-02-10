package tests.lesson_21.config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:properties/auth.properties",
        "system:properties"
})

public interface AuthConfig extends Config {

    @Config.Key("username.selenoid")
    String remote_username();

    @Config.Key("password.selenoid")
    String remote_password();
}
