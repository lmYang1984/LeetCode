package leetcode.lmy.com.动态规划.最小路径和_64;

class Solution {
    public int minPathSum(int[][] grid) {
        //dp[i][j]表示从左上角到该点的最小值
        int row = grid.length;
        int col = grid[0].length;
        int[][] dp = new int[row][col];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < col; i ++)
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        for (int j = 1; j < row; j ++)
            dp[j][0] = dp[j - 1][0] + grid[j][0];

        for (int i = 1; i < row; i ++) {
            for (int j = 1; j < col; j ++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }

        return dp[row - 1][col - 1];
    }
}
