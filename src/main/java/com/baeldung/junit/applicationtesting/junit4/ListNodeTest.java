package com.baeldung.junit.applicationtesting.junit4;
import com.baeldung.junit.applicationtesting.listnode.ListNode;

import org.junit.Test;
import junit.framework.TestCase;



public class ListNodeTest extends TestCase {

    public ListNodeTest() {}

    public ListNodeTest(String name) {
        super(name);
    }
    
    @Test
    public void testListNodeInt() {
        ListNode listNode = new ListNode(42);
        assertEquals(listNode.getValue(), 42);
    }

    @Test
    public void testListNodeIntListNode() {
        ListNode listNode = new ListNode(42, new ListNode(666, null));
        assertEquals(listNode.getValue(), 42);
        assertEquals(listNode.getNext().getValue(), 666);
    }

    @Test
    public void testToString() {
        ListNode listNode = new ListNode(42, new ListNode(666, new ListNode(15, null)));
        assertEquals(listNode.toString(), "42->666->15");
    }

}
