package com.baeldung.junit.applicationtesting.junit4;

import org.junit.Test;
import junit.framework.TestCase;

import com.baeldung.junit.applicationtesting.listnode.SwapNodes;
import com.baeldung.junit.applicationtesting.listnode.ListNode;

class SwapNodesTest extends TestCase {
    private SwapNodes swapNodes;
    private ListNode listNode;

    public SwapNodesTest() {}
    public SwapNodesTest(String name) { super(name); }
    
    public void setUp() throws Exception {
        swapNodes = new SwapNodes();
        listNode = new ListNode(42, new ListNode(666, new ListNode(15, new ListNode(3, null))));
    }

    @Test
    void whenSwappingPairs_thenReturnExpectedList() {
        assertEquals(swapNodes.swapPairs(listNode)
            .toString(), "666->42->3->15");
    }

}
