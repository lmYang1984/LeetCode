package leetcode.lmy.com.二叉树.对称二叉树_101;

/**
 * Definition for a binary tree node.
        * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return false;
        }

        return dfs(root.left, root.right);
    }

    public boolean dfs(TreeNode a, TreeNode b) {
        if (a == null && b == null) return true;
        if (a == null || b == null || a.val != b.val) return false;

        boolean l = dfs(a.left, b.right);
        boolean r = dfs(a.right, b.left);

        return l && r;
    }
}