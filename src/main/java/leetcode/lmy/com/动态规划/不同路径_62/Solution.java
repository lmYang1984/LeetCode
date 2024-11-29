package leetcode.lmy.com.动态规划.不同路径_62;

class Solution {
    public int uniquePaths(int m, int n) {
        //和跳楼梯差不多的dp
        //dp[i][j]表示到达i，j坐标时含有的路径数
        // int[][] dp = new int[m][n];
        // for (int i = 0; i < m; i ++) dp[i][0] = 1;
        // for (int i = 0; i < n; i ++) dp[0][i] = 1;

        // for (int i = 1; i < m; i ++) {
        //     for (int j = 1; j < n; j ++) {
        //         dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
        //     }
        // }

        //优化dp[i]表示到达i位置时的路径数，依次迭代更新至第m - 1行
        int[] dp = new int[n];
        for (int i = 0; i < n; i ++) dp[i] = 1;

        for (int i = 1; i < m; i ++) {
            for (int j = 1; j < n; j ++) {
                dp[j] = dp[j - 1] + dp[j];
            }
        }

        return dp[n - 1];
    }
}