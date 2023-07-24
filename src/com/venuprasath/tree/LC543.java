package com.venuprasath.tree;

public class LC543 {

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

    int dm = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) return dm;
        dfs(root);
        return dm;
    }

    private int dfs(TreeNode root) {
        if(root == null) return -1;
        int left = dfs(root.left);
        int right = dfs(root.right);
        dm = Math.max(dm, left+right+2);
        return 1+Math.max(left, right);
    }

}
