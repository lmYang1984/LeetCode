package leetcode.lmy.com.回溯.子集_78;

import java.util.ArrayList;
import java.util.List;

class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        dfs(nums, 0);

        return res;
    }

    public void dfs(int[] nums, int idx) {
        res.add(new ArrayList<>(path));

        if (path.size() == nums.length) return;

        for (int i = idx; i < nums.length; i++) {
            path.add(nums[i]);
            dfs(nums, i + 1);
            path.remove(path.size() - 1);
        }
    }
}