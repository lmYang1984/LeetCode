package leetcode.lmy.com.最长公共子序列_1143;

public class Solution {
    /**
     * 其精髓在于原始问题划分为子问题时候的分类讨论
     * @param text1
     * @param text2
     * @return
     */
    public int longestCommonSubsequence(String text1, String text2) {
        int len1 = text1.length();
        int len2 = text2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];//dp[i][j]表示t1 i - 1和 t2 j - 1的最大公共子序列

        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[len1][len2];
    }

    public int longestCommonSubsequence1(String text1, String text2) {
        int len1 = text1.length();
        int len2 = text2.length();

        int[] dp = new int[len2 + 1];

        for (int i = 1; i <= len1; i ++) {
            int pre = dp[0];
            for (int j = 1; j <= len2; j ++) {
                int tmp = dp[j];
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[j] = pre + 1;
                } else {
                    dp[j] = Math.max(dp[j - 1],dp[j]);
                }

                pre = tmp;
            }
        }

        return dp[len2];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.longestCommonSubsequence("abcde", "ace"));
    }
}
