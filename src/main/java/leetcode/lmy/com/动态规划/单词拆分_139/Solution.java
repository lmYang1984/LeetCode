package leetcode.lmy.com.动态规划.单词拆分_139;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        int maxLen = 0;
        for (String word : wordDict)
            maxLen = Math.max(maxLen, word.length());

        int n = s.length();
        //dp[i]表示字符串以i-1为end能否被wordDict组成
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;

        for (int i = 1; i <= n; i++) {
            for (int j = i - 1; j >= Math.max(i - maxLen, 0) ; j--) {
                if (dp[j] && set.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return  dp[n];
    }
}

