package leetcode.lmy.com.双指针.无重复字符的最长子串_3;

import java.util.HashMap;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null) return 0;

        //滑动窗口 + 哈希表
        HashMap<Character, Integer> map = new HashMap<>();
        char[] ss = s.toCharArray();
        int n = ss.length;
        int l = 0;
        int r = 0;
        int res = 0;

        for (; r < n; r ++) {
            if (!map.containsKey(ss[r])) {
                map.put(ss[r], 1);
                res = Math.max(r - l + 1, res);
            } else {
                while (map.containsKey(ss[r])) {
                    map.remove(ss[l]);
                    l ++;
                }
                map.put(ss[r], 1);
            }
        }

        return res;
    }
}
