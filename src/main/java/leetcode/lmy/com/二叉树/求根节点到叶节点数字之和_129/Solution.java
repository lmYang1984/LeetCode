package leetcode.lmy.com.二叉树.求根节点到叶节点数字之和_129;

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
    int sum = 0;
    public int sumNumbers(TreeNode root) {
        dfs(root, 0);

        return sum;
    }

    public void dfs(TreeNode root, int path) {
        if (root == null) return;

        //path表示当前结点的值，如果不是叶子那么他应该传递给l和r
        //l和r计算完之后自然会返回
        path = path * 10 + root.val;
        if (root.left == root.right) {
            sum += path;
            return;
        }

        dfs(root.left, path);
        dfs(root.right, path);
    }
}
