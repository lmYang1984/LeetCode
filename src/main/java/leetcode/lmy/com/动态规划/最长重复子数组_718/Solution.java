package leetcode.lmy.com.动态规划.最长重复子数组_718;

class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        //最长重复子串
        int m = nums1.length;
        int n = nums2.length;
        //dp[i][j]表示n1以i-1结尾，n2以j-1结尾，两者最长的重复子串
        int[][] dp = new int[m + 1][n + 1];
        int res = 0;

        for (int i = 1; i <= m; i ++) {
            for (int j = 1; j <= n; j ++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    //这个递推公式是用来计算最长公共子序列的，它不要求元素必须连续
                    //dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }

                res = Math.max(res, dp[i][j]);
            }
        }

        return res;
    }
}
