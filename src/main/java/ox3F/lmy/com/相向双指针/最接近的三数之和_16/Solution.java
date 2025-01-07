package ox3F.lmy.com.相向双指针.最接近的三数之和_16;

import java.util.Arrays;

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int res = 0;
        int resGap = Integer.MAX_VALUE;

        for (int i = 0; i < n - 2; i ++) {
            if (i != 0 && nums[i] == nums[i - 1]) continue;

            int l = i + 1;
            int r = n - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                int curGap = Math.abs(target - sum);
                if (curGap < resGap) {
                    res = sum;
                    resGap = curGap;
                }

                if (sum > target) {
                    r --;
                } else if (sum < target) {
                    l ++;
                } else {
                    return target;
                }

            }

        }

        return res;
    }
}
