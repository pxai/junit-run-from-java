package com.baeldung.junit.applicationtesting.junit4;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.Test;
import junit.framework.TestCase;

import com.baeldung.junit.applicationtesting.listnode.ListNode;
import com.baeldung.junit.applicationtesting.listnode.MergeLists;

public class MergeListsTest extends TestCase {

    private ListNode listNode1;
    private ListNode listNode2;
    private MergeLists mergeLists;

    public MergeListsTest() {
    }

    public MergeListsTest(String name) {
        super(name);
    }

    public void setUp() throws Exception {
        mergeLists = new MergeLists();
        listNode1 = new ListNode(2, new ListNode(4, new ListNode(6, new ListNode(8, null))));
        listNode2 = new ListNode(1, new ListNode(3, new ListNode(5, new ListNode(7, null))));
    }

    @Test
    void whenMergingNormalLists_thenGetExpectedString() {
        assertEquals(mergeLists.merge(listNode1, listNode2)
            .toString(), "1->2->3->4->5->6->7->8");
    }

    @Test
    void whenMergingNullLists_thenGetNull() {
        listNode1 = null;
        listNode2 = null;
        assertNull(mergeLists.merge(listNode1, listNode2));
    }
}
