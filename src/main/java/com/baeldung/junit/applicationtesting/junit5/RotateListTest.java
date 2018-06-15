package com.baeldung.junit.applicationtesting.junit5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.baeldung.junit.applicationtesting.listnode.RotateList;

import com.baeldung.junit.applicationtesting.listnode.ListNode;

class RotateListTest {
    private RotateList rotateList;
    private ListNode listNode;
    
    @BeforeEach
    void setUp() throws Exception {
        rotateList = new RotateList();
        listNode = new ListNode(42, new ListNode(666, new ListNode(15, new ListNode(3,null))));
    }

    @Test
    void testRotateRight() {
       assertEquals(rotateList.rotateRight(listNode, 2).toString(),"15->3->42->666");
    }

    @Test
    void testRotateRight2() {
       assertEquals(rotateList.rotateRight(listNode, 3).toString(),"666->15->3->42");
    }
}
