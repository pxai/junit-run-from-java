package com.baeldung.junit.applicationtesting.junit5;

import static org.junit.platform.engine.discovery.ClassNameFilter.includeClassNamePatterns;
import static org.junit.platform.engine.discovery.DiscoverySelectors.selectClass;
import static org.junit.platform.engine.discovery.DiscoverySelectors.selectPackage;

import java.io.PrintWriter;

import org.junit.platform.launcher.Launcher;
import org.junit.platform.launcher.LauncherDiscoveryRequest;
import org.junit.platform.launcher.TestExecutionListener;
import org.junit.platform.launcher.TestPlan;
import org.junit.platform.launcher.core.LauncherDiscoveryRequestBuilder;
import org.junit.platform.launcher.core.LauncherFactory;
import org.junit.platform.launcher.listeners.SummaryGeneratingListener;
import org.junit.platform.launcher.listeners.TestExecutionSummary;

public class RunJUnit5Tests {
    SummaryGeneratingListener listener =  new SummaryGeneratingListener();
    public void runAll() {
//        LauncherDiscoveryRequest request = LauncherDiscoveryRequestBuilder.request()
//            .selectors(selectPackage("com.baeldung.junit.applicationtesting.junit5"), selectClass(ListNodeTest.class))
//            .filters(includeClassNamePatterns(".*Tests"))
//            .build();

       LauncherDiscoveryRequest request = LauncherDiscoveryRequestBuilder.request()
            .selectors(
                    selectPackage("com.baeldung.junit.applicationtesting.junit5") 
            ) .filters(
                includeClassNamePatterns(".*Test")
                )
            .build();
        Launcher launcher = LauncherFactory.create();

        TestPlan testPlan = launcher.discover(request);
        System.out.println(testPlan.toString());
        System.out.println("TEsts: " + testPlan.containsTests());

        launcher.registerTestExecutionListeners(listener);

        launcher.execute(request);

    }

    public static void main(String[] args) {
        // check:https://junit.org/junit5/docs/current/user-guide/#launcher-api
        //https://junit.org/junit5/docs/current/user-guide/#running-tests-build-gradle-engines-configure
        // https://junit.org/junit5/docs/current/user-guide/#running-tests-build-gradle-engines-configure
        RunJUnit5Tests runner = new RunJUnit5Tests();
        runner.runAll();
        TestExecutionSummary summary = runner.listener.getSummary();
        summary.printTo(new PrintWriter(System.out));
        System.out.println("Hello World!");
    }
}
