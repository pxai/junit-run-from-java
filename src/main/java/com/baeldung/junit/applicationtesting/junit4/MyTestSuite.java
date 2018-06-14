package com.baeldung.junit.applicationtesting.junit4;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
    ListNodeTest.class,
    MergeListsTest.class
})
public class MyTestSuite {

}
