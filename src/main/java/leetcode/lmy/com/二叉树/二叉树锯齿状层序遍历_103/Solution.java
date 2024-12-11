package leetcode.lmy.com.二叉树.二叉树锯齿状层序遍历_103;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<TreeNode> dq = new ArrayDeque<>();
        boolean flag = true;
        if (root == null) return res;
        dq.add(root);
        while (!dq.isEmpty()) {
            int n = dq.size();
            Deque<Integer> path = new ArrayDeque<>();
            for (int i = 0; i < n; i ++) {
                TreeNode tmp = dq.pollFirst();
                if (flag)
                    path.addLast(tmp.val);
                else
                    path.addFirst(tmp.val);

                if (tmp.left != null) dq.addLast(tmp.left);
                if (tmp.right != null) dq.addLast(tmp.right);
            }
            flag = !flag;
            res.add(new ArrayList(path));
        }


        return res;
    }
}