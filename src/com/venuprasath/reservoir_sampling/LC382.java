package com.venuprasath.reservoir_sampling;

import java.util.ArrayList;
import java.util.Random;

import static com.venuprasath.util.Extension.println;

public class LC382 {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {}
        ListNode (int val) { this.val = val; }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        int ans = getRandom(head);
        println(ans);
    }

    static ArrayList<Integer> list = new ArrayList<>();
    private static Random random = new Random();

    public static int getRandom(ListNode head) {
        while(head != null) {
            list.add(head.val);
            head = head.next;
        }

        return list.get(random.nextInt(list.size()));
    }
}
