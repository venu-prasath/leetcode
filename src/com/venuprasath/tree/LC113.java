package com.venuprasath.tree;

import java.util.ArrayList;
import java.util.List;

public class LC113 {

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

    List<List<Integer>> result = new ArrayList();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<Integer> subList = new ArrayList<>();
        dfs(root, subList, targetSum);
        return result;
    }

    public void dfs(TreeNode node, List<Integer> subList, int targetSum) {
        if(node == null) return;
        subList.add(node.val);
        if(node.left == null && node.right == null && node.val == targetSum) result.add(new ArrayList<>(node.val));

        dfs(node.left, subList, targetSum-node.val);
        dfs(node.right, subList, targetSum - node.val);
        subList.remove(subList.size() - 1);
    }
}
