package com.venuprasath.tree;

import java.util.ArrayList;
import java.util.List;

public class LC515 {

    public class TreeNode {
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

    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList();
        bfs(root, res, 0);
        return res;
    }

    private void bfs(TreeNode root, List<Integer> res, int level) {
        if(root == null) return;
        if(level > res.size()) {
            res.add(root.val);
        } else {
            res.set(level, Math.max(res.get(level), root.val));
        }
        bfs(root.left, res, level+1);
        bfs(root.right, res, level+1);
    }
}
