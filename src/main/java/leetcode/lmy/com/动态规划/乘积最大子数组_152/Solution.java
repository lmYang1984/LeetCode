package leetcode.lmy.com.动态规划.乘积最大子数组_152;

class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        //dp[i][0]表示以元素i为结尾的最大值
        //dp[i][1]表示以元素i为结尾的最小值
        int[][] dp = new int[n][2];
        dp[0][0] = nums[0];
        dp[0][1] = nums[0];

        for (int i = 1; i < n; i ++) {
            //根据当前数的正负判定 当前i的最值情况
            if (nums[i] > 0) {
                dp[i][0] = Math.max(nums[i], dp[i - 1][0] * nums[i]);
                dp[i][1] = Math.min(nums[i], dp[i - 1][1] * nums[i]);
            } else {
                dp[i][0] = Math.max(nums[i], dp[i - 1][1] * nums[i]);
                dp[i][1] = Math.min(nums[i], dp[i - 1][0] * nums[i]);
            }
        }

        int res = dp[0][0];
        for (int i = 1; i < n; i ++)
            res = Math.max(res, dp[i][0]);

        return res;
    }
}