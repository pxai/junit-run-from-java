package com.baeldung.junit.applicationtesting.junit5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.baeldung.junit.applicationtesting.listnode.RemovedNthElement;

import com.baeldung.junit.applicationtesting.listnode.ListNode;

class RemovedNthElementTest {
    
    private ListNode listNode;
    private RemovedNthElement removedNthElement;
    
    @BeforeEach
    void setUp() throws Exception {
        removedNthElement = new RemovedNthElement();
        listNode = new ListNode(42, new ListNode(666, new ListNode(15, new ListNode(3,null))));
    }

    @Test
    void testRemoveNthFromEnd() {
       assertEquals(removedNthElement.removeNthFromEnd(listNode,2).toString(),"42->666->3");
    }

    @Test
    void testRemoveNthFromEnd2() {
       assertEquals(removedNthElement.removeNthFromEnd(listNode,3).toString(),"42->15->3");
    }
}
