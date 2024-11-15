package leetcode.lmy.com.二叉树.二叉树的右视图_199;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Deque;

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> dq = new ArrayDeque<>();

        if (root == null) return res;
        dq.add(root);
        while (!dq.isEmpty()) {
            int len = dq.size();
            for (int i = 0; i < len; i++) {
                TreeNode tmp = dq.pollFirst();
                if (tmp.left != null) dq.addLast(tmp.left);
                if (tmp.right != null) dq.addLast(tmp.right);

                if (i == len - 1) res.add(tmp.val);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // 测试用例 1: 空树
        TreeNode root1 = null;
        List<Integer> result1 = solution.rightSideView(root1);
        System.out.println("Test Case 1: " + result1); // 应输出 []

        // 测试用例 2: 单节点树
        TreeNode root2 = new TreeNode(1);
        List<Integer> result2 = solution.rightSideView(root2);
        System.out.println("Test Case 2: " + result2); // 应输出 [1]

        // 测试用例 3: 完全二叉树
        TreeNode root3 = new TreeNode(1);
        root3.left = new TreeNode(2);
        root3.right = new TreeNode(3);
        root3.left.left = new TreeNode(4);
        root3.right.left = new TreeNode(5);
        root3.right.right = new TreeNode(6);
        List<Integer> result3 = solution.rightSideView(root3);
        System.out.println("Test Case 3: " + result3); // 应输出 [1, 3, 6]

        // 测试用例 4: 不完全二叉树
        TreeNode root4 = new TreeNode(1);
        root4.left = new TreeNode(2);
        root4.right = new TreeNode(3);
        root4.left.left = new TreeNode(4);
        root4.right.right = new TreeNode(5);
        root4.left.left.left = new TreeNode(6);
        root4.right.right.right = new TreeNode(7);
        List<Integer> result4 = solution.rightSideView(root4);
        System.out.println("Test Case 4: " + result4); // 应输出 [1, 3, 5, 7]
    }
}
