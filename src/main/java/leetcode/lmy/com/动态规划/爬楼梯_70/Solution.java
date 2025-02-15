package leetcode.lmy.com.动态规划.爬楼梯_70;

class Solution {
    public int climbStairs(int n) {
        if (n == 1 || n == 2) return n;

        //dp[i]表示爬到i阶有的方法数
        int[] dp = new int[n + 1];

        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i ++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }
}