package com.venuprasath.linkedlist;

import java.util.ArrayList;
import java.util.List;

import static com.venuprasath.util.Extension.print;

public class LC21 {

    public static void main(String[] args) {

        LC21 solution = new LC21();
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(3);
        list.add(5);
        ListNode head1 = solution.prepareList(list);
        list.clear();
        list.add(2);
        list.add(4);
        list.add(6);
        ListNode head2 = solution.prepareList(list);
        ListNode node = solution.mergeTwoLists(head1, head2);
        while(node != null) {
            print(node.val);
            node = node.next;
        }
    }

    ListNode prepareList(List<Integer> list) {
        ListNode node = new ListNode(0);
        ListNode head = node;
        for(Integer item: list) {
            ListNode itm = new ListNode(item);
            node.next = itm;
            node = node.next;
        }
        return head;
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode sHead = new ListNode();
        ListNode curr = sHead;
        ListNode ptr1 = list1;
        ListNode ptr2 = list2;

        while(ptr1 != null && ptr2 != null) {
            if(ptr1.val <= ptr2.val) {
                curr.next = ptr1;
                ptr1 = ptr1.next;
            } else {
                curr.next = ptr2;
                ptr2 = ptr2.next;
            }
            curr = curr.next;
        }

        while(ptr1 != null) {
            curr.next = ptr1;
            ptr1 = ptr1.next;
            curr = curr.next;
        }

        while(ptr2 != null) {
            curr.next = ptr2;
            ptr2 = ptr2.next;
            curr = curr.next;
        }

        return sHead.next;
    }

    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
