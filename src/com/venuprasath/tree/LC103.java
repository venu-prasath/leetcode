package com.venuprasath.tree;

import java.util.*;

import static com.venuprasath.util.Extension.print;

public class LC103 {

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
        LC102.TreeNode root = new LC102.TreeNode(1);
        root.left = new LC102.TreeNode(9);
        root.right = new LC102.TreeNode(20);
        root.right.left = new LC102.TreeNode(15);
        root.right.right = new LC102.TreeNode(7);

        LC102 solution = new LC102();
        List<List<Integer>> result = solution.levelOrder(root);

        for(List<Integer> subList: result) {
            for(Integer val: subList) {
                print(val);
            }
        }
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root == null) return new ArrayList();
        return zigzag(root);
    }

    boolean fromLeft = true;
    public List<List<Integer>> zigzag(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if(root == null) return new ArrayList<>();
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
            if(!fromLeft) {
                Collections.reverse(subList);
            }
            fromLeft = !fromLeft;
            result.add(subList);
        }
        return result;
    }
}
