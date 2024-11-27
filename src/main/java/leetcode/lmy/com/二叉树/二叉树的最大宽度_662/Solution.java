package leetcode.lmy.com.二叉树.二叉树的最大宽度_662;

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
import java.util.HashMap;
import java.util.Map;

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
    int res = 0;
    Map<Integer, Integer> leftMostPosition = new HashMap<>();

    public int widthOfBinaryTree(TreeNode root) {
        // 调用 dfs 方法遍历树，初始深度为0，节点索引为0
        // 传入的position是每一层的编号
        dfs(root, 0, 0);
        return res;
    }

    public void dfs(TreeNode node, int depth, int position) {
        if (node == null) return;

        // 记录每一层最左边节点的位置
        leftMostPosition.putIfAbsent(depth, position);

        // 计算当前层的宽度，并更新全局最大宽度
        res = Math.max(res, position - leftMostPosition.get(depth) + 1);

        // 递归调用左右子树，更新深度和位置
        dfs(node.left, depth + 1, 2 * position);
        dfs(node.right, depth + 1, 2 * position + 1);
    }
}
