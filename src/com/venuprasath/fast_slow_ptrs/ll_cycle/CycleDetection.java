package com.venuprasath.fast_slow_ptrs.ll_cycle;

import java.util.*;

public class CycleDetection{
    public static boolean detectCycle(LinkedListNode head) {

        if(head == null || head.next == null) return false;
        LinkedListNode slow = head;
        LinkedListNode fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast) return true;
        }


        return false;
    }
}