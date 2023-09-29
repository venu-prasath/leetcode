package com.venuprasath.tree;

public class LC530 {

    public class TreeNode {
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

    public static void main(String[] args) {

    }

    int minDiff = Integer.MAX_VALUE;
    public int gertMinDiff(TreeNode root) {
        inorder(root);
        return minDiff;
    }

    Integer prev = null;
    private void inorder(TreeNode root) {
        if(root == null) return;
        inorder(root.left);
        if(prev != null) {
            minDiff = Math.min(minDiff, root.val - prev);
        }
        prev = root.val;
        inorder(root.right);
    }
}
