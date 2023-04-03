package com.venuprasath.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import static com.venuprasath.util.Extension.print;

public class LC102 {

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
        // [3,9,20,null,null,15,7]
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        LC102 solution = new LC102();
        List<List<Integer>> result = solution.levelOrder(root);

        for(List<Integer> subList: result) {
            for(Integer val: subList) {
                print(val);
            }
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) return new ArrayList<>();
        return bfs(root);
    }

    public List<List<Integer>> bfs(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if(root == null) return null;
        queue.add(root);

        while(!queue.isEmpty()) {
            int childCount = queue.size();
            List<Integer> subList = new ArrayList<>();
            for(int i=0; i<childCount; i++) {
                if(queue.peek().left != null) {
                    queue.add(queue.peek().left);
                }
                if(queue.peek().right != null) {
                    queue.add(queue.peek().right);
                }
                subList.add(queue.remove().val);
            }
            result.add(subList);
        }
        return result;
    }
}
