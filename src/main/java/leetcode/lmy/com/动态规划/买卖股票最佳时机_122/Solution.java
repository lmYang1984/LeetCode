package leetcode.lmy.com.动态规划.买卖股票最佳时机_122;

class Solution {
    public int maxProfit(int[] prices) {
        // int pre = prices[0];//维护之前的最小值
        // int res = 0;
        // for (int i = 0; i < prices.length; i ++) {
        //     pre = Math.min(pre, prices[i]);
        //     res = Math.max(res, prices[i] - pre);
        // }

        // return res;
        //上面不可以反复售卖
        //dp[i][0]表示第i天持有股票的最大利润
        //dp[i][1]表示第i天未持有股票的最大利润
        int n = prices.length;
        int[][] dp = new int[n][2];
        dp[0][0] = 0 - prices[0];
        dp[0][1] = 0;

        for(int i = 1; i < n; i ++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i]);
        }

        return Math.max(dp[n - 1][0], dp[n - 1][1]);
    }
}