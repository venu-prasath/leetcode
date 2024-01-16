package com.venuprasath.two_pointers;

import static com.venuprasath.util.Extension.println;

public class LC86 {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode();
        head.next = new ListNode(5);
        head.next.next = new ListNode(4);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next = new ListNode(1);
        head = head.next;

        head = partition(head, 3);
        while(head != null) {
            println(head.val);
            head = head.next;
        }
    }

    public static ListNode partition(ListNode head, int x) {
        if(head == null) return head;
        ListNode sHead1 = new ListNode();
        ListNode sHead2 = new ListNode();
        ListNode ptr1 = sHead1;
        ListNode ptr2 = sHead2;
        ListNode curr = head;

        while(curr != null) {
            if(curr.val < x) {
                ptr1.next = curr;
                ptr1 = ptr1.next;
            } else {
                ptr2.next = curr;
                ptr2 = ptr2.next;
            }
            curr = curr.next;
        }
        ptr1.next = sHead2.next;
        ptr2.next = null;
        return sHead1.next;
    }
}
