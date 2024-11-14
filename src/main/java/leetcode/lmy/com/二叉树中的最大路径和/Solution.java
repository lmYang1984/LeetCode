package leetcode.lmy.com.二叉树中的最大路径和;

/**
 *  经过某节点的最大路径和 = left最大链和 + right最大链和 + nodeval
 *  res统计所有节点的最大路径和中的最值
 *
 */

class Solution {
    private int ans = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return ans;
    }

    private int dfs(TreeNode node) {
        if (node == null) {
            return 0; // 没有节点，和为 0
        }

        int lVal = dfs(node.left); // 左子树最大链和
        int rVal = dfs(node.right); // 右子树最大链和
        ans = Math.max(ans, lVal + rVal + node.val); // 维护经过自己的最大路径和

        //若要拼接该节点，只能选择一边的节点和
        return Math.max(Math.max(lVal, rVal) + node.val, 0); // 当前子树最大链和
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode testRoot1 = new TreeNode(1);

        TreeNode testRoot2 = new TreeNode(-10);
        testRoot2.left = new TreeNode(9);
        testRoot2.right = new TreeNode(20);
        testRoot2.right.right = new TreeNode(7);
        testRoot2.right.left = new TreeNode(15);
        System.out.println(s.dfs(testRoot1));
        System.out.println(s.maxPathSum(testRoot2));
    }
}

