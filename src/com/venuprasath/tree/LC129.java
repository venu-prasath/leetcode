package com.venuprasath.tree;

import java.util.ArrayList;

public class LC129 {

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

    public int sumNumbers(TreeNode root) {
        ArrayList<String> arr = new ArrayList<>();
        int sum = 0;
        sum(root, arr, "");
        for(int i=0; i<arr.size(); i++) {
            sum += Integer.valueOf(arr.get(i));
        }
        return sum;
    }

    public void sum(TreeNode root, ArrayList<String> arr, String str) {
        if(root == null) return;
        if(root.left == null && root.right == null) {
            str += Integer.toString(root.val);
            arr.add(str);
        }
        if(root.left != null && root.right != null) {
            str += Integer.toString(root.val);
            sum(root.left, arr, str);
            sum(root.right, arr, str);
        }
        if(root.left != null && root.right == null) {
            str += Integer.toString(root.val);
            sum(root.left, arr, str);
        }
        if(root.left == null && root.right != null) {
            str += Integer.toString(root.val);
            sum(root.right, arr, str);
        }
    }
}
