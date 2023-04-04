package com.venuprasath.tree;

import java.util.HashMap;
import java.util.Map;

import static com.venuprasath.util.Extension.println;

public class LC105 {

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
        // preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
        int[] preorder = new int[] {3, 9, 20, 15, 7 };
        int[] inorder = new int[] { 9, 3, 15, 20, 7 };
        LC105 solution = new LC105();
        TreeNode root = solution.buildTree(preorder, inorder);
        inorder(root);
    }

    public static void inorder(TreeNode root) {
        if(root == null) return;
        inorder(root.left);
        println(root.val + " -> ");
        inorder(root.right);
    }

    int preorderIndex = 0;
    Map<Integer, Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i=0; i<inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildTree(preorder, 0, preorder.length-1);
    }

    public TreeNode buildTree(int[] preorder, int left, int right) {
        if(left > right) return null;
        int rootValue = preorder[preorderIndex++];
        TreeNode rootNode = new TreeNode(rootValue);
        int pivotIndex = map.get(rootValue);
        rootNode.left = buildTree(preorder, left, pivotIndex-1);
        rootNode.right = buildTree(preorder, pivotIndex+1, right);
        return rootNode;
    }
}
