package com.venuprasath.stack;

public class LC155 {

    public static void main(String[] args) {
        //eg - ["MinStack","push","push","push","getMin","pop","top","getMin"]
        //ip - [[],[-2],[0],[-3],[],[],[],[]]
    }
}

class MinStack {
    Node head = null;
    class Node {
        int value = 0;
        int min = 0;
        Node node = null;

        Node(int val, int min, Node node) {
            this.value = val;
            this.min = min;
            this.node = node;
        }
    }

    public MinStack() {

    }

    public void push(int val) {
        if(head == null) {
            head = new Node(val, val, null);
        } else {
            Node node = new Node(val, Math.min(head.min, val), head);
            head = node;
        }
    }

    public void pop() {
        head = head.node;
    }

    public int top() {
        return head.value;
    }

    public int getMin() {
        return head.min;
    }
}
