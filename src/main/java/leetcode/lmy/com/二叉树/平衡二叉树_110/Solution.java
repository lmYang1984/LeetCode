package leetcode.lmy.com.二叉树.平衡二叉树_110;

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
    public boolean isBalanced(TreeNode root) {
        //经典平衡二叉树，感觉这个和求深度那个题有关系
        //判断L和R高度是不是在1以内，然后每个结点都这样判断一下
        return dfs(root) == -1 ? false : true;
    }

    public int dfs(TreeNode root) {
        if (root == null) return 0;

        int l = dfs(root.left);
        int r = dfs(root.right);

        if (l == -1 || r == -1 || Math.abs(l - r) > 1) return -1;

        return Math.max(l, r) + 1;
    }
}
