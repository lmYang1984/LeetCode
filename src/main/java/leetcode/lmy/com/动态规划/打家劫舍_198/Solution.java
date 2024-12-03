package leetcode.lmy.com.动态规划.打家劫舍_198;

class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][2];
        //dp[i][0]表示第i个房间没有被偷的最大金额
        //dp[i][1]表示第i个房间被偷的最大金额
        dp[0][0] = 0;
        dp[0][1] = nums[0];

        for (int i = 1; i < n; i ++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            dp[i][1] = dp[i - 1][0] + nums[i];
        }

        return Math.max(dp[n - 1][0], dp[n - 1][1]);
    }
}