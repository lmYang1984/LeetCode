package leetcode.lmy.com.回溯.路径总和_113;

import java.util.ArrayList;
import java.util.List;

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
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        //dfs + 回溯
        backTracking(root, targetSum);

        return res;
    }

    public void backTracking(TreeNode root, int targetSum) {
        if (root == null) return;
        if (root.left == root.right && targetSum == root.val) {
            path.add(root.val);
            res.add(new ArrayList(path));
            path.remove(path.size() - 1);
            return;
        }

        path.add(root.val);
        backTracking(root.left, targetSum - root.val);
        backTracking(root.right, targetSum - root.val);
        path.remove(path.size() - 1);
    }
}
