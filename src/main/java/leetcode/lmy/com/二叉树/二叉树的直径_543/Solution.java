package leetcode.lmy.com.二叉树.二叉树的直径_543;

/**
 * 递归:dfs定义这个函数就是返回这个节点出发的最大链长
 * 一个节点的最大链长 = MAX(L + R) + 1
 *        1
 *       / \
 *      2   3
 *     / \
 *    4   5
 *    dfs(1) = Max(dfs(2) + dfs(3)) + 1
 *    dfs(2) = Max(dfs(4) + dfs(5) + 1
 *    dfs(4) = Max(dfs(null) + dfs(null)) + 1
 *    理解题目意思,这个路径指的是边长,先理解答案应该返回什么
 *    dfs(1) = 3
 *    dfs(4) = 0 所以null里面才应该填-1
 */

class Solution {
    int res = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);

        return res;
    }

    public int dfs(TreeNode root) {
        if (root == null) return -1;

        int l = dfs(root.left);
        int r = dfs(root.right);
        //dfs(1) = dfs(2) + dfs(3) + 2;
        res = Math.max(res, l + r + 2);//自己做转折点

        return Math.max(l, r) + 1;//作为root的一个分支，只能选l或者r
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // 测试用例1: 空树
        TreeNode root1 = null;
        System.out.println("Diameter (空树): " + sol.diameterOfBinaryTree(root1)); // 期望: 0

        // 测试用例2: 单节点树
        TreeNode root2 = new TreeNode(1);
        System.out.println("Diameter (单节点): " + sol.diameterOfBinaryTree(root2)); // 期望: 0

        // 测试用例3: 线性树 (左子树链长为2)
        TreeNode root3 = new TreeNode(1);
        root3.left = new TreeNode(2);
        root3.left.left = new TreeNode(3);
        System.out.println("Diameter (线性树): " + sol.diameterOfBinaryTree(root3)); // 期望: 2

        // 测试用例4: 树结构如题目示例
        TreeNode root4 = new TreeNode(1);
        root4.left = new TreeNode(2);
        root4.right = new TreeNode(3);
        root4.left.left = new TreeNode(4);
        root4.left.right = new TreeNode(5);
        System.out.println("Diameter (示例树): " + sol.diameterOfBinaryTree(root4)); // 期望: 3
    }
}
