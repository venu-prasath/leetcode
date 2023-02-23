package com.venuprasath.linkedlist;

import java.util.PriorityQueue;

public class LC23 {

    public static void main(String[] args) {

    }

    public LC143.ListNode mergeKLists(LC143.ListNode[] lists) {
        if(lists.length == 0) return null;
        PriorityQueue<LC143.ListNode> minHeap = createMinHeap(lists);
        LC143.ListNode sHead = new LC143.ListNode();
        LC143.ListNode tail = sHead;

        while(!minHeap.isEmpty()) {
            LC143.ListNode topNode = minHeap.poll();
            tail.next = topNode;
            tail = tail.next;
            if(topNode.next != null) {
                minHeap.add(topNode.next);
            }
        }
        return sHead.next;
    }

    private PriorityQueue<LC143.ListNode> createMinHeap(LC143.ListNode[] lists) {
        PriorityQueue<LC143.ListNode> queue = new PriorityQueue<>((n1, n2) -> n1.val - n2.val);
        for(LC143.ListNode node: lists) {
            if(node != null) {
                queue.add(node);
            }
        }
        return queue;
    }
}
