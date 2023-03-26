package com.venuprasath.tree;

public class LC101 {

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

    public static void main(String[] args) {

    }

    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return isMirror(root.left, root.right);
    }

    public boolean isMirror(TreeNode first, TreeNode second) {
        if(first == null && second == null) return true;
        if(first == null || second == null) return false;
        return (first.val == second.val) &&
                isMirror(first.left, second.right) &&
                isMirror(first.right, second.left);
    }
}
