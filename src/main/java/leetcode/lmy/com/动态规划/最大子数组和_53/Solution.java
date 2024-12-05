package leetcode.lmy.com.动态规划.最大子数组和_53;

class Solution {
    public int maxSubArray(int[] nums) {
        if (nums.length == 1) return nums[0];
        //连续子数组是连着的
        int n = nums.length;
        //dp[i]表示以i结尾的最大子数组和
        int[] dp = new int[n];
        int res = nums[0];
        dp[0] = nums[0];

        for (int i = 1; i < n; i ++) {
            dp[i] = Math.max(nums[i], nums[i] + dp[i - 1]);
            res = Math.max(dp[i], res);
        }

        return res;
    }
}
