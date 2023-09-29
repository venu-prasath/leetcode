package com.venuprasath.tree;

import java.util.ArrayList;
import java.util.List;

public class LC257 {

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

    List<String> res = new ArrayList<>();
    public List<String> binaryPathSum(TreeNode root) {
        helper(root, "");
        for(int i=0; i<res.size(); i++) {
            res.set(i, res.get(i).substring(2));
        }
        return res;
    }

    private void helper(TreeNode root, String curr) {
        if(root == null) return;
        String str = curr+"->"+root.val;
        if(root.left == null && root.right == null) res.add(str);
        helper(root.left, str);
        helper(root.right, str);
    }
}
