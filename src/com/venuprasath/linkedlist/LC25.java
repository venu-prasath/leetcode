package com.venuprasath.linkedlist;

public class LC25 {

    public static void main(String[] args) {

    }

    public LC143.ListNode reverseKGroup(LC143.ListNode head, int k) {
        if(head == null) return null;
        LC143.ListNode curr = head;
        LC143.ListNode tail = null;
        LC143.ListNode prev = null;
        int counter = 0;

        while(counter < k && curr != null) {
            counter++;
            tail = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tail;
        }

        if(counter < k) {
            return reverseKGroup(prev, counter);
        }

        if(tail != null) {
            head.next = reverseKGroup(curr, k);
        }
        return prev;
    }
}
