package com.venuprasath.tree;

import java.util.LinkedList;
import java.util.Queue;

public class LC116 {

    public static void main(String[] args) {

    }

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };

    public Node connect(Node root) {
        return modifiedBfs(root);
    }

    public Node modifiedBfs(Node root) {
        if(root == null) return null;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            int childCount = queue.size();
            Node lastNode = null;
            for(int i=0; i<childCount; i++) {
                if(queue.peek().left != null) {
                    if(lastNode != null) {
                        lastNode.next = queue.peek().left;
                        lastNode = null;
                    }
                    queue.add(queue.peek().left);
                }
                if(queue.peek().right != null) {
                    queue.add(queue.peek().right);
                    lastNode = queue.peek().right;
                    if(queue.peek().left != null) {
                        queue.peek().left.next = queue.peek().right;
                    }
                }
                queue.remove();
            }
        }
        return root;
    }
}
