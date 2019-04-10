package com.pastorm.stormuiframework.annotations;

import org.openqa.selenium.Platform;

import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Repeatable(UseBrowserContainer.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface UseBrowser {
    String url();
    String browser();
    String version() default "";
    Platform platform() default Platform.ANY;
}

