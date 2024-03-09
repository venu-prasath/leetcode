package com.venuprasath.linkedlist;

import java.util.List;

import static com.venuprasath.util.Extension.println;

public class ReverseList {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode curr = head;
        while(curr != null) {
            println(curr.val + " ");
            curr = curr.next;
        }
        curr = head;
        head = reverse(curr);
        curr = head;
        while(curr != null) {
            println(curr.val + " ");
            curr = curr.next;
        }
    }

    public static ListNode reverse(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;
        ListNode next = null;

        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }
}
