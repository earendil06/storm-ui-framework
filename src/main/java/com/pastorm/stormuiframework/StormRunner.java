package com.pastorm.stormuiframework;


import com.pastorm.stormuiframework.annotations.UseBrowser;
import org.junit.Test;
import org.junit.runner.Description;
import org.junit.runner.Runner;
import org.junit.runner.notification.RunNotifier;

import java.lang.reflect.Method;
import java.util.Optional;

public class StormRunner extends Runner {

    private Class<? extends StormUITest> testClass;

    public StormRunner(Class<? extends StormUITest> testClass) {
        super();
        this.testClass = testClass;
    }

    @Override
    public Description getDescription() {
        return Description
                .createTestDescription(testClass, "StormRunner performing selenium tests");
    }

    @Override
    public void run(RunNotifier notifier) {
        UseBrowser[] contexts =
                Optional.ofNullable(testClass.getAnnotationsByType(UseBrowser.class))
                        .orElse(new UseBrowser[]{});
        try {
            StormUITest testObject = testClass.newInstance();
            for (UseBrowser context : contexts) {
                testObject.initWithContext(context);

                for (Method method : testClass.getMethods()) {
                    if (method.isAnnotationPresent(Test.class)) {
                        notifier.fireTestStarted(Description
                                .createTestDescription(testClass, method.getName()));
                        method.invoke(testObject);
                        notifier.fireTestFinished(Description
                                .createTestDescription(testClass, method.getName()));
                    }
                }

                testObject.getDriver().quit();
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}
