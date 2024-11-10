package leetcode.lmy.com.二叉树的直径;

/**
 * 递归:dfs定义这个函数就是返回这个节点出发的最大链长
 * 一个节点的最大链长 = 左子树最大链子长 + 右子树最大链长 + 1
 *        1
 *       / \
 *      2   3
 *     / \
 *    4   5
 *    dfs(1) = Max(dfs(2))
 */

class Solution {
    private int ans;

    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return ans;
    }

    private int dfs(TreeNode node) {
        if (node == null) {
            return -1;
        }
        int lLen = dfs(node.left) + 1; // 左子树最大链长+1
        int rLen = dfs(node.right) + 1; // 右子树最大链长+1
        ans = Math.max(ans, lLen + rLen); // 两条链拼成路径
        return Math.max(lLen, rLen); // 当前子树最大链长
    }

    public static void main(String[] args) {

    }
}
