package com.venuprasath.tree;

import java.util.ArrayList;
import java.util.List;

public class LC94 {

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
        TreeNode root = new TreeNode(1);
        LC94 sol = new LC94();
        sol.inorderTraversal(root);
    }

    List<Integer> result = new ArrayList();
    public List<Integer> inorderTraversal(TreeNode root) {
        inorder(root);
        return result;
    }

    public void inorder(TreeNode root) {
        if(root == null) return;
        inorder(root.left);
        result.add(root.val);
        inorder(root.right);
    }
}
