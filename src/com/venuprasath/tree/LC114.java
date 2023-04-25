package com.venuprasath.tree;

public class LC114 {

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
        //[1,2,5,3,4,null,6]
        TreeNode root = new TreeNode(1);
        LC114 sol = new LC114();
        sol.flatten(root);

    }

    public void flatten(TreeNode root) {
        dfs(root);
        return;
    }

    TreeNode prev = null;
    public void dfs(TreeNode root) {
        if(root == null) return;
        dfs(root.right);
        dfs(root.left);
        root.right = prev;
        root.left = null;
        prev = root;
    }
}
