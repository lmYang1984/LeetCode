package ox3F.lmy.com.相向双指针0.四数之和_18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < n - 3; i ++) {
            if (target <= 0 && nums[i] > 0) continue;

            if (i != 0 && nums[i] == nums[i - 1]) continue;
            for (int j = i + 1; j < n - 2; j ++) {
                if (j != i + 1 && nums[j] == nums[j - 1]) continue;

                int l = j + 1;
                int r = n - 1;
                while (l < r) {
                    long sum = nums[i] + nums[j] + nums[l] + nums[r];
                    if (sum > target) {
                        r --;
                    } else if (sum < target) {
                        l ++;
                    } else {
                        List<Integer> ans = new ArrayList<>();
                        ans.add(nums[i]);
                        ans.add(nums[j]);
                        ans.add(nums[l]);
                        ans.add(nums[r]);
                        res.add(new ArrayList<>(ans));
                        while(l < r && nums[r] == nums[r - 1]) r --;
                        while(l < r && nums[l] == nums[l + 1]) l ++;
                        l ++;
                        r --;
                    }
                }
            }
        }

        return res;
    }
}
