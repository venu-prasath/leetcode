package com.venuprasath.two_pointers;


import static com.venuprasath.util.Extension.println;

public class LC61 {

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
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(5);
        head = head.next;

        head = rotateRight(head, 2);
        while(head != null) {
            println(head.val);
            head = head.next;
        }
    }

    private static ListNode rotateRight(ListNode head, int k) {
        if(head == null) return head;
        int count = 1;
        ListNode first = head;
        ListNode second = head;
        ListNode sHead = head;
        while(first.next != null) {
            first = first.next;
            count++;
        }
        k = k%count;
        if(k == 0) return head;
        for(int i=1; i<count-k; i++) {
            second = second.next;
        }
        sHead = second.next;
        first.next = head;
        second.next = null;
        return sHead;
    }
}
