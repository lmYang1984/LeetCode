package leetcode.lmy.com.二叉树.从前序与中序遍历序列构造二叉树_105;

import java.util.HashMap;

public class Solution {
    HashMap<Integer, Integer> inorderMap = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        for (int i = 0; i < n; i++) {
            inorderMap.put(inorder[i], i);
        }

        return  dfs(0, n, preorder, 0, n, inorder);
    }

    public TreeNode dfs(int prel, int prer, int[] preorder, int inl, int inr, int[] inorder) {
        if (prel >= prer) return null;
        int leftSize = inorderMap.get(preorder[prel]) - inl;
        TreeNode root = new TreeNode(preorder[prel]);

        //root left right;
        //left root right;
        root.left = dfs(prel + 1, prel + 1 +leftSize, preorder, inl, inl + leftSize, inorder);
        root.right = dfs(prel + 1 + leftSize, prer, preorder, inl + leftSize + 1, inr, inorder);

        return root;
    }
}
