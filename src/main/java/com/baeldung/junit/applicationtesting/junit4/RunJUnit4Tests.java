package com.baeldung.junit.applicationtesting.junit4;


import junit.extensions.ActiveTestSuite;
import junit.extensions.RepeatedTest;
import junit.framework.TestSuite;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.junit.runners.Suite;

public class RunJUnit4Tests {

    public static void runOne () {
        junit.textui.TestRunner.run(new TestSuite(MergeListsTest.class));
    }
    
    public static void runAllClasses () {
        Result result = JUnitCore.runClasses(ListNodeTest.class);

        for (Failure failure : result.getFailures()) {
           System.out.println(failure.toString());
        }
                  
        System.out.println(resultReport(result));
    }
    
    public static void runSuiteOfClasses () {        
        Result result = JUnitCore.runClasses(MyTestSuite.class);
        
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
         }
                   
         System.out.println(resultReport(result));

    }
    
    public static String resultReport(Result result) {
        return "Finished. Result " + ". Failures: " + result.getFailureCount()
        + ". Ignored: " + result.getIgnoreCount() + ". Tests runt: "
        + result.getRunCount() + ". Time: " + result.getRunTime() + "ms.";
    }
    
    public static void runRepeated () {
        RepeatedTest repeatedTest = new RepeatedTest(new TestSuite(MergeListsTest.class),5);
        junit.textui.TestRunner.run(repeatedTest);
    }
    
    public static void runRepeatedTestMethod () {
        TestSuite mySuite = new ActiveTestSuite( );
        
        mySuite.addTest(new RepeatedTest(new MergeListsTest("testListNodeIntListNode"),50));
        mySuite.addTest(new RepeatedTest(new MergeListsTest("testToString"),10));

        junit.textui.TestRunner.run(mySuite);
    }

    public static void main(String[] args) {
        System.out.println("\nRunning one test class:");
        runOne();
        
        System.out.println("\nRunning all test classes:");
        runAllClasses();
        
        System.out.println("\nRunning a suite of test classes:");
        runSuiteOfClasses();
        
        System.out.println("\nRunning repeated tests:");
        runRepeated();
        
        System.out.println("\nRunning repeated tests on specific test methods:");
        runRepeatedTestMethod();
        
    }
}