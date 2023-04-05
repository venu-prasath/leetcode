package com.venuprasath.tree;

public class LC108 {

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

    public TreeNode sortedArrayToBST(int[] nums) {
        return createBST(nums, 0, nums.length-1);
    }

    public TreeNode createBST(int[] nums, int left, int right) {
        if(left > right) return null;

        int mid = (left+right)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = createBST(nums, left, mid-1);
        root.right = createBST(nums, mid+1, right);
        return root;
    }
}
