package leetcode.lmy.com.双指针.三数之和_15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n - 2; i ++) {
            if (i != 0 && nums[i - 1] == nums[i]) continue;

            int l = i + 1;
            int r = n - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum > 0) {
                    r --;
                } else if (sum < 0) {
                    l ++;
                } else {
                    List<Integer> path = new ArrayList<>();
                    path.add(nums[i]);
                    path.add(nums[l]);
                    path.add(nums[r]);
                    res.add(new ArrayList(path));
                    while (l < r && nums[r - 1] == nums[r]) r --;
                    while (l < r && nums[l + 1] == nums[l]) l ++;
                    l ++;
                    r --;
                }
            }
        }

        return res;
    }
}