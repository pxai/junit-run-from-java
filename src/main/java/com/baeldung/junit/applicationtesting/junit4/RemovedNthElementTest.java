package com.baeldung.junit.applicationtesting.junit4;


import com.baeldung.junit.applicationtesting.listnode.RemovedNthElement;

import org.junit.Test;
import junit.framework.TestCase;

import com.baeldung.junit.applicationtesting.listnode.ListNode;

class RemovedNthElementTest  extends TestCase {
    
    private ListNode listNode;
    private RemovedNthElement removedNthElement;
    
    public RemovedNthElementTest () {}
    
    public RemovedNthElementTest (String name) { super(name); }
    
    public void setUp() throws Exception {
        removedNthElement = new RemovedNthElement();
        listNode = new ListNode(42, new ListNode(666, new ListNode(15, new ListNode(3,null))));
    }

    @Test
    public void whenRemovingSecondElement_thenReturnExpectedList() {
       assertEquals(removedNthElement.removeNthFromEnd(listNode,2).toString(),"42->666->3");
    }

    @Test
    public void whenRemovingThirdElement_thenReturnExpectedList() {
       assertEquals(removedNthElement.removeNthFromEnd(listNode,3).toString(),"42->15->3");
    }
}
