package com.venuprasath.tree;

import java.util.Random;
import java.util.Stack;

/**
 * @author Vincent Cancelliere
 * @pledge I pledge my honor that I have abided by the Stevens Honor System
 */
public class Treap <E extends Comparable<E>>{
    /*private static class Node<E> {
        public E data;
        public int priority;
        public Node<E> left;
        public Node<E> right;

        *//**
         *
         * @param data is implemented into the new Node's data
         * @param priority is implemented into the new Node's priority
         * @throws NullPointerException when the data is null
         *//*
        public Node (E data, int priority) {
            if (data == null)
                throw new NullPointerException("Input data is null");
            this.data = data;
            this.priority = priority;
        }

        public Node<E> rotateRight() {
            Node<E> temp = left.right;
            Node<E> l = left;
            left.right = this;
            left = temp;
            return l;
        }

        public Node<E> rotateLeft() {
            Node<E> temp = right.left;
            Node<E> r = right;
            right.left = this;
            right = temp;
            return r;
        }

        @Override
        public String toString() {
            return "[" + data + " " + priority + "]";
        }
    }

    private Random priorityGenerator;
    private Node<E> root;

    public Treap() {
        priorityGenerator = new Random();
        root = null;
    }

    *//**
     *
     * @param seed is implemented to make a new Random for priorityGenerator
     *//*
    public Treap(long seed) {
        priorityGenerator = new Random(seed);
        root = null;
    }

    public boolean add(E data) {
        return add(data, priorityGenerator.nextInt());
    }

    public boolean add(E data, int priority) {
        if (find(data))
            return false;
        Node<E> n = new Node(data, priority);
        Node<E> current = root;
        Stack<Node<E>> s = new Stack<Node<E>>();

        //BST Insert
        if (root == null)
            root = n;
        else {
            while (current != null) {
                s.push(current);
                if (n.data.compareTo(current.data) < 0) {
                    if (current.left == null) {
                        current.left = n;
                        current = null;
                    }
                    else
                        current = current.left;
                }
                else {
                    if (current.right == null) {
                        current.right = n;
                        current = null;
                    } else
                        current = current.right;
                }
            }
            //While loop to maintain Treap Property
            Node temp = null;
            current = null;
            while (s.size() > 0 && s.peek().priority < n.priority) {
                if (s.peek().right == n) {
                    temp = s.pop();
                    current = temp.rotateLeft();
                }
                else {
                    temp = s.pop();
                    current = s.pop().rotateRight();
                }
            }
            if (s.size() > 0) {
                if (s.peek().right == temp) {
                    s.pop().right = current;
                }
                else {
                    s.pop().left = current;
                }
            }
        }
        return true;
    }

    boolean delete(E key) {
        if (!find(key))
            return false;
        Node n = finder(root, key);
        while (n.right != null || n.left != null) {
            if (n.right != null && n.left != null) {
                if (n.left.data.compareTo(n.right.data) < 0)
                    n.rotateLeft();
                else
                    n.rotateLeft();
            }
            else if(n.left != null)
                n.rotateRight();
            else
                n.rotateLeft();
        }
        Node<E> parent = parentFinder(n, root);
        if (parent.left == n)
            parent.left = null;
        else
            parent.right = null;
        return true;
    }

    *//**
     * This is a helper function I made
     *
     * @param root is the node you are comparing to find the Node
     * @param key is the data you are comparing to the Node's data
     * @return the Node found or return null if not found
     *//*
    private Node<E> finder(Node<E> root, E key) {
        if (root.data.compareTo(key) == 0)
            return root;
        if (root.left != null)
            if (find(root.left, key)) {
                return finder(root.left, key);
            }
            else if (root.right != null) {
                return finder(root.right, key);
            }
        return null;
    }

    private Node<E> parentFinder(Node<E> child, Node<E> parent) {
        if (parent.left == child || parent.right == child)
            return parent;
        if (parent.left != null)
            if (find(parent.left, child.data)) {
                parentFinder(child, parent.left);
            }
            else if(parent.right != null)
                if (find(parent.right, child.data))
                    parentFinder(child, parent.right);
        return null;
    }

    private boolean find(Node<E> root,E key) {
        boolean l = false, r = false;
        if (root.data.compareTo(key) == 0)
            return true;
        if (root.left != null)
            l = find(root.left, key);
        if (root.right != null)
            r = find(root.right, key);
        return l || r;
    }
    boolean find(E key) {
        return find (root, key);
    }

    @Override
    public String toString() {
        return toString(root, 0);
    }
    private String toString(Node<E> root, int level) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < level; i++) {
            sb.append("-");
        }
        if (root == null) {
            sb.append("null\n");
        } else {
            sb.append(root.data.toString()+"\n");
            sb.append(toString(root.left, level + 1));
            sb.append(toString(root.right,level + 1));
        }
        return sb.toString();
    }*/

}
