package com.venuprasath.linkedlist;

public class LC141 {

    public static void main(String[] args) {
        LC141 solution = new LC141();
        solution.hasCycle(new LC143.ListNode());
    }

    public boolean hasCycle(LC143.ListNode head) {
        if(head == null || head.next == null) return false;

        LC143.ListNode slowPtr = head;
        LC143.ListNode fastPtr = head;

        while(fastPtr.next != null) {
            fastPtr = fastPtr.next;

            if(fastPtr.next != null) {
                fastPtr = fastPtr.next;
                slowPtr = slowPtr.next;
            }

            if(slowPtr == fastPtr) {
                return true;
            }
        }
        return false;
    }
}
