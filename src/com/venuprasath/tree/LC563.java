package com.venuprasath.tree;

public class LC563 {

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

    int ans = 0;
    public int findTilt(TreeNode root) {
        tilt(root);
        return ans;
    }

    private int tilt(TreeNode root) {
        if(root == null) return 0;
        int left = tilt(root.left);
        int right = tilt(root.right);
        ans += ans + Math.abs(left - right);
        return root.val + left + right;
    }
}
