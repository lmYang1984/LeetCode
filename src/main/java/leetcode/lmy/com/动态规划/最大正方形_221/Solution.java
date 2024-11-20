package leetcode.lmy.com.动态规划.最大正方形_221;

class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;

        int col = matrix.length;
        int row = matrix[0].length;
        int[][]dp = new int[col + 1][row + 1];
        int res = 0;

        for (int i = 1; i <= col; i ++) {
            for (int j = 1; j <= row; j ++) {
                if (matrix[i - 1][j - 1] == '1') {
                    dp[i][j] =
                            myMin(dp[i - 1][j - 1], dp[i - 1][j], dp[i][j - 1]) + 1;

                    res = Math.max(res, dp[i][j]);
                }
            }
        }

        return res * res;
    }

    public int myMin(int a, int b, int c) {
        return Math.min(Math.min(a, b), c);
    }
}