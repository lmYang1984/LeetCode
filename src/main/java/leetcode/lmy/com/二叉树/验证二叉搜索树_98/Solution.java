package leetcode.lmy.com.二叉树.验证二叉搜索树_98;

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
    long pre = Long.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
        //二叉搜索树的中序遍历是一个单调递增序列
        if (root == null) return true;

        //l
        boolean l = isValidBST(root.left);
        if (l == false) return false;

        //mid
        if (pre >= root.val) return false;
        pre = root.val;

        //r
        boolean r = isValidBST(root.right);
        if (r == false) return false;

        return true;
    }
}
