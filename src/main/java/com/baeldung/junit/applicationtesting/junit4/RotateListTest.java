package com.baeldung.junit.applicationtesting.junit4;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import junit.framework.TestCase;

import com.baeldung.junit.applicationtesting.listnode.RotateList;
import com.baeldung.junit.applicationtesting.listnode.ListNode;

class RotateListTest  extends TestCase {
    private RotateList rotateList;
    private ListNode listNode;
    
    public RotateListTest() {}
    public RotateListTest(String name) { super(name); }
    
    public void setUp() throws Exception {
        rotateList = new RotateList();
        listNode = new ListNode(42, new ListNode(666, new ListNode(15, new ListNode(3,null))));
    }

    @Test
    void whenRotatingListTwice_thenReturnExpectedList() {
       assertEquals(rotateList.rotateRight(listNode, 2).toString(),"15->3->42->666");
    }

    @Test
    void whenRotatingListThreeTimes_thenReturnExpectedList() {
       assertEquals(rotateList.rotateRight(listNode, 3).toString(),"666->15->3->42");
    }
}
