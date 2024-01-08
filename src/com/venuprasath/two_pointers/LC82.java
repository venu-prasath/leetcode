package com.venuprasath.two_pointers;

import static com.venuprasath.util.Extension.println;

public class LC82 {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode();
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(3);
        head.next.next.next.next.next = new ListNode(4);
        head = head.next;
        head = deleteDuplicates(head);
        while(head != null) {
            println(head.val);
            head = head.next;
        }

    }

    private static ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode sHead = new ListNode();
        sHead.next = head;
        ListNode ptr = sHead;

        while(head != null) {
            if(head.next != null && head.val == head.next.val) {
                while(head.next != null && head.val == head.next.val) {
                    head = head.next;
                }
                ptr.next = head.next;
            } else {
                ptr = ptr.next;
            }
            head = head.next;
        }
        return sHead.next;
    }
}
