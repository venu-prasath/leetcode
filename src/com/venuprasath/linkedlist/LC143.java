package com.venuprasath.linkedlist;

public class LC143 {

    public static void main(String[] args) {
        //eg - head = [1,2,3,4]
        int[] arr = new int[] { 1, 2, 3, 4};
        ListNode head = new ListNode();
        head.val = 1;
        ListNode curr = head;
        for(int itm: arr) {
            ListNode node = new ListNode(itm);
            node.val = itm;
            curr.next = node;
            curr = curr.next;
        }
        LC143 solution = new LC143();
        solution.reorderList(head);
    }

    public void reorderList(ListNode head) {

    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
