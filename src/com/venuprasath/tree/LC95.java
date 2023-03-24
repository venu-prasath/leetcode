package com.venuprasath.tree;

import java.util.ArrayList;
import java.util.List;

import static com.venuprasath.util.Extension.println;

public class LC95 {

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

    public void inorder(TreeNode root) {
        if(root == null) return;
        inorder(root.left);
        println(root.val + " -> ");
        inorder(root.right);
    }

    public static void main(String[] args) {
        LC95 solution = new LC95();
        List<TreeNode> answer = solution.generateTrees(3);
        for(TreeNode root: answer) {
            solution.inorder(root);
            println("\n");
        }
    }

    public List<TreeNode> generateTrees(int n) {
        if(n == 0) return new ArrayList<>();
        return generateTrees(1, n);
    }

    public List<TreeNode> generateTrees(int left, int right) {
        List<TreeNode> roots = new ArrayList<>();

        if(left > right) {
            roots.add(null);
        } else {
            for(int i = left; i<= right; i++) {
                List<TreeNode> leftSubtrees = generateTrees(left, i-1);
                List<TreeNode> rightSubtrees = generateTrees(i+1, right);

                for(TreeNode leftSubtree: leftSubtrees) {
                    for(TreeNode rightSubtree: rightSubtrees) {
                        TreeNode root = new TreeNode(i);
                        root.left = leftSubtree;
                        root.right = rightSubtree;
                        roots.add(root);
                    }
                }
            }
        }

        return roots;
    }
}
