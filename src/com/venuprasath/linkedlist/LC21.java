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
        LC143.ListNode head1 = solution.prepareList(list);
        list.clear();
        list.add(2);
        list.add(4);
        list.add(6);
        LC143.ListNode head2 = solution.prepareList(list);
        LC143.ListNode node = solution.mergeTwoLists(head1, head2);
        while(node != null) {
            print(node.val);
            node = node.next;
        }
    }

    LC143.ListNode prepareList(List<Integer> list) {
        LC143.ListNode node = new LC143.ListNode(0);
        LC143.ListNode head = node;
        for(Integer item: list) {
            LC143.ListNode itm = new LC143.ListNode(item);
            node.next = itm;
            node = node.next;
        }
        return head;
    }

    public LC143.ListNode mergeTwoLists(LC143.ListNode list1, LC143.ListNode list2) {
        LC143.ListNode sHead = new LC143.ListNode();
        LC143.ListNode curr = sHead;
        LC143.ListNode ptr1 = list1;
        LC143.ListNode ptr2 = list2;

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

}
