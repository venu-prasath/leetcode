package com.venuprasath.tree;

public class LC538 {

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

    int value = 0;
    public TreeNode convert(TreeNode root) {
        modifiedInorder(root);
        return root;
    }

    private void modifiedInorder(TreeNode root) {
        if(root == null) return;
        modifiedInorder(root.right);
        value += root.val;
        root.val = value;
        modifiedInorder(root.left);
    }

}
