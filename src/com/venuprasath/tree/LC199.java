package com.venuprasath.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LC199 {

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

    public List<Integer> rightSideView(TreeNode root) {
        return bfs(root);
    }

    public List<Integer> bfs(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            int childCount = queue.size();
            for(int i=0; i<childCount; i++) {
                TreeNode curr = queue.poll();
                if(i == 0) {
                    result.add(curr.val);
                }
                if(curr.right != null) {
                    queue.offer(curr.right);
                }
                if(curr.left != null) {
                    queue.offer(curr.left);
                }
            }
        }
        return result;
    }
}
