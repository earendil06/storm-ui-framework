package com.pastorm.stormuiframework.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface UseBrowserContainer {
    UseBrowser[] value();
}
