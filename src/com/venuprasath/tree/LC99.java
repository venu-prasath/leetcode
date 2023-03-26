package com.venuprasath.tree;

public class LC99 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    TreeNode prev=null,first=null,second=null;

    public static void main(String[] args) {
        LC99 solution = new LC99();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.left.right = new TreeNode(2);
        solution.recoverTree(root);
    }

    public void recoverTree(TreeNode root) {
        if(root == null) return;
        inorder(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    public void inorder(TreeNode root) {
        if(root == null) return;
        inorder(root.left);
        if(prev != null && root.val < prev.val) {
            if(first == null) first = prev;
            second = root;
        }
        prev = root;
        inorder(root.right);
    }
}
