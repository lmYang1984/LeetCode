package leetcode.lmy.com.动态规划.最长有效括号_32;

class Solution {
    public int longestValidParentheses(String s) {
        int res = 0;
        int len = s.length();
        char[] ch = s.toCharArray();
        int[] dp = new int[len];

        for (int i = 1; i < len; i++) {
            if (ch[i] == ')') {
                if (ch[i - 1] == '(') {
                    dp[i] = i > 2 ? dp[i - 2] + 2 : 2;
                } else if (i - 1 - dp[i - 1] >= 0 && ch[i - 1 - dp[i - 1]] == '(') {
                    //( ( ( ) ) )
                    if (i - 2 - dp[i - 1] >= 0) {
                        dp[i] = dp[i - 1] + 2 + dp[i - 2 - dp[i - 1]];
                    } else {
                        dp[i] = dp[i - 1] + 2;
                    }
                }
            }

            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
