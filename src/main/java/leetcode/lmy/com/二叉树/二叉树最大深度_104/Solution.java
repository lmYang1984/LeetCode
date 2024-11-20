package leetcode.lmy.com.二叉树.二叉树最大深度_104;


import java.util.ArrayList;
import java.util.List;

class Solution {
    int res = 0;

    public int maxDepth(TreeNode root) {
        dfs(root, 1);

        return res;
    }

    public void dfs(TreeNode root, int depth) {
        if (root == null) return;
        if (root.left == root.right) {
            res = Math.max(res, depth);
            return;
        }

        dfs(root.left, depth + 1);
        dfs(root.right, depth + 1);
    }
}