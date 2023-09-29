package com.venuprasath.tree;

/**
 * @author Vincent Cancelliere
 * @pledge I pledge my honor that I have abided by the Stevens Honor System
 */

//eg - [40, 20, 10, 25, 30, 22, 50 ]

public class AVL {

    public static void main(String[] args) {

    }

    public static class Node {
        Integer data = null;
        Node left = null;
        Node right = null;
        int height = 0;

        Node(Integer data) {
            if(data == null)
                throw new NullPointerException("Input data is null");
            this.data = data;
        }
    }

    Node root = null;

    public void add(Integer data) {
        root = addAt(data, root);
    }

    public Node addAt(Integer data, Node node) {
        if(node == null) return new Node(data);

        if(data < node.data) {
            node.left = addAt(data, node.left);
        } else if(data > node.data) {
            node.right = addAt(data, node.right);
        } else {
            return node;
        }
        return null;
    }


}