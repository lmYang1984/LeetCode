package leetcode.lmy.com.动态规划.最长递增子序列_300;

import java.util.Arrays;

class Solution {
    public int lengthOfLIS(int[] nums) {
        //子序列中间可以不连续
        //dp[i]出的最长子序列可由[0, i - 1]的dp得来
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int res = 1;
        for (int i = 1; i < n; i ++) {
            for (int j = 0; j < i; j ++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }

        return res;
    }
}
