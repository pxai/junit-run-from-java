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

import com.baeldung.junit.applicationtesting.junit4.ListNodeTest;

public class RunJUnit5Tests {
    SummaryGeneratingListener listener = new SummaryGeneratingListener();

    public void runAll() {

        LauncherDiscoveryRequest request = LauncherDiscoveryRequestBuilder.request()
            .selectors(selectPackage("com.baeldung.junit.applicationtesting.junit5"))
            .filters(includeClassNamePatterns(".*Test"))
            .build();
        Launcher launcher = LauncherFactory.create();

        TestPlan testPlan = launcher.discover(request);
        System.out.println("Tests: " + testPlan.containsTests());

        launcher.registerTestExecutionListeners(listener);

        launcher.execute(request);

    }

    public static void main(String[] args) {
        RunJUnit5Tests runner = new RunJUnit5Tests();
        runner.runAll();

        TestExecutionSummary summary = runner.listener.getSummary();
        summary.printTo(new PrintWriter(System.out));
    }
}
