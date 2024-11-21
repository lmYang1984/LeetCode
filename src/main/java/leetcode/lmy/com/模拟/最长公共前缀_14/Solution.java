package leetcode.lmy.com.模拟.最长公共前缀_14;

class Solution {
    public String longestCommonPrefix(String[] strs) {
        int idx = -1;
        for (int i = 0; i < strs[0].length(); i ++) {
            for (int j = 1; j < strs.length; j ++) {
                if (i >= strs[j].length() || strs[0].charAt(i) != strs[j].charAt(i)) {
                    return idx == -1 ? "" : strs[0].substring(0, i);
                }
            }
            idx = i;
        }

        return strs[0];
    }
}
