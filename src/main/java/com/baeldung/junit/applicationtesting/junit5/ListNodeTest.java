package com.baeldung.junit.applicationtesting.junit5;
import com.baeldung.junit.applicationtesting.listnode.ListNode;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;



class ListNodeTest {

    @Test
    void testListNodeInt() {
        ListNode listNode = new ListNode(42);
        assertEquals(listNode.getValue(), 42);
    }

    @Test
    void testListNodeIntListNode() {
        ListNode listNode = new ListNode(42, new ListNode(666, null));
        assertEquals(listNode.getValue(), 42);
        assertEquals(listNode.getNext().getValue(), 666);
    }

    @Test
    void testToString() {
        ListNode listNode = new ListNode(42, new ListNode(666, new ListNode(15, null)));
        assertEquals(listNode.toString(), "42->666->15");
    }

}
