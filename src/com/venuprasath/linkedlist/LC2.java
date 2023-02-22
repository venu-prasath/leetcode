package com.venuprasath.linkedlist;

public class LC2 {

    public static void main(String[] args) {
        LC2 solution = new LC2();
        solution.addTwoNumbers(new LC143.ListNode(1), new LC143.ListNode(4));
    }

    public LC143.ListNode addTwoNumbers(LC143.ListNode l1, LC143.ListNode l2) {
        int sum = 0;
        int carry = 0;
        LC143.ListNode head = new LC143.ListNode();

        LC143.ListNode current = head;
        LC143.ListNode temp = null;

        while(l1 != null && l2 != null) {
            int total = l1.val + l2.val + carry;
            carry = 0;
            sum = total%10;
            carry = total/10;
            LC143.ListNode node = new LC143.ListNode(sum);
            current.next = node;
            current = current.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        while(l1 != null) {
            int total = l1.val + carry;
            carry = 0;
            sum = total%10;
            carry = total/10;
            LC143.ListNode node = new LC143.ListNode(sum);
            current.next = node;
            current = current.next;
            l1 = l1.next;
        }

        while(l2 != null) {
            int total = l2.val + carry;
            carry = 0;
            sum = total%10;
            carry = total/10;
            LC143.ListNode node = new LC143.ListNode(sum);
            current.next = node;
            current = current.next;
            l2 = l2.next;
        }
        if(carry > 0) {
            LC143.ListNode node = new LC143.ListNode(carry);
            current.next = node;
        }
        return head.next;
    }
}
