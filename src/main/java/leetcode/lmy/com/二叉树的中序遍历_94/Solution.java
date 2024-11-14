package leetcode.lmy.com.二叉树的中序遍历_94;

import java.util.ArrayList;
import java.util.List;

class Solution {
    List<Integer> res = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        dfs(root);

        return res;
    }

    public void dfs(TreeNode root){
        if (root == null) return;

        dfs(root.left);
        res.add(root.val);
        dfs(root.right);
    }
}