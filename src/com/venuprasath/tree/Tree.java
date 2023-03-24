package com.venuprasath.tree;

import static com.venuprasath.util.Extension.print;
import static com.venuprasath.util.Extension.println;

public class Tree {

    public static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    Node root;

    public Tree() {
        root = null;
    }

    public void inorder(Node root) {
        if(root == null) return;
        inorder(root.left);
        println(root.data + " -> ");
        inorder(root.right);
    }

    public void preorder(Node root) {
        if(root == null) return;
        println(root.data + " -> ");
        preorder(root.left);
        preorder(root.right);
    }

    public void postOrder(Node root) {
        if(root == null) return;
        postOrder(root.left);
        postOrder(root.right);
        println(root.data + " -> ");
    }

    boolean isFullBinaryTree(Node root) {
        if(root == null) return true;

        if(root.left == null && root.right == null) return true;

        if((root.left != null) && (root.right != null)) {
            return (isFullBinaryTree(root.left) && isFullBinaryTree(root.right));
        }
        return false;
    }

    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.root = new Node(1);
        tree.root.left = new Node(12);
        tree.root.right = new Node(9);
        tree.root.left.left = new Node(5);
        tree.root.left.right = new Node(6);

        print("\nInorder Traversal: ");
        tree.inorder(tree.root);

        print("\nPreorder Traversal: ");
        tree.preorder(tree.root);

        print("\nPostorder Traversal: ");
        tree.postOrder(tree.root);

        if (tree.isFullBinaryTree(tree.root))
            print("\nThe tree is a full binary tree");
        else
            print("\nThe tree is not a full binary tree");
    }


}
