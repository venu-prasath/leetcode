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

    TreeNode first=null,second=null;

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

    TreeNode prev = new TreeNode(Integer.MIN_VALUE);
    public void inorder(TreeNode root) {
        if(root == null) return;
        inorder(root.left);

        if(first == null && prev.val > root.val) {
            first = prev;
        }
        if(first != null && prev.val > root.val) {
            second = root;
        }

        prev = root;
        inorder(root.right);
    }
}
