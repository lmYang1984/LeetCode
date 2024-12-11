package leetcode.lmy.com.回溯.全排列_46;

import java.util.ArrayList;
import java.util.List;

class Solution {
    private List<List<Integer>> res = new ArrayList<>();
    private List<Integer> path = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        boolean[] visted = new boolean[nums.length];
        dfs(nums, visted);

        return res;
    }

    private void dfs(int[] nums, boolean[] visted) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i ++) {
            if (!visted[i]) {
                visted[i] = true;
                path.add(nums[i]);
                dfs(nums, visted);
                path.remove(path.size() - 1);
                visted[i] = false;
            }
        }
    }
}