package leetcode.lmy.com.二叉树.二叉树的前序遍历_144;


import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    List<Integer> res = new ArrayList<>();

    public List<Integer> preorderTraversal(TreeNode root) {
        preorder(root);

        return res;
    }

    public void preorder(TreeNode root) {
        if (root == null) return;

        res.add(root.val);
        preorder(root.left);
        preorder(root.right);
    }
}