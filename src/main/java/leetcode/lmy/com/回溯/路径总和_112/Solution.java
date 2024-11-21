package leetcode.lmy.com.回溯.路径总和_112;

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
    boolean res = false;

    public boolean hasPathSum(TreeNode root, int targetSum) {
        backTracking(root, targetSum);

        return res;
    }

    public void backTracking(TreeNode root, int targetSum) {
        if (res) return;
        if (root == null) return;
        if (root.left == root.right && targetSum == root.val) {
            res = true;
            return;
        }

        backTracking(root.left, targetSum - root.val);
        backTracking(root.right, targetSum - root.val);
    }
}