package leetcode.lmy.com.二叉树.树的层序遍历_102;

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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<TreeNode> dq = new ArrayDeque<>();
        if (root == null) return res;
        dq.addLast(root);
        while (!dq.isEmpty()) {
            int n = dq.size();
            List<Integer> path = new ArrayList<>();
            for (int i = 0; i < n; i ++) {
                TreeNode tmp = dq.pollFirst();
                path.add(tmp.val);
                if (tmp.left != null) dq.addLast(tmp.left);
                if (tmp.right != null) dq.addLast(tmp.right);
            }
            res.add(path);
        }

        return res;
    }
}