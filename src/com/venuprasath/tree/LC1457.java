package com.venuprasath.tree;

public class LC1457 {

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

    static int count=0;
    public int pseudoPalindromicPaths (TreeNode root) {
        preorder(root, 0);
        return count;
    }

    public static void preorder(TreeNode node, int path) {
        if(node != null) {
            path = path ^ (1 << node.val);
            if(node.left == null && node.right == null) {
                if((path & (path-1)) == 0) {
                    ++count;
                }
            }
            preorder(node.left, path);
            preorder(node.right, path);
        }
    }
}
