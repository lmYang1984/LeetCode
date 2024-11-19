package leetcode.lmy.com.模拟.翻转字符串中的单词_151;

class Solution {
    public String reverseWords(String s) {
        String[] strs = s.trim().split(" ");
        StringBuilder res = new StringBuilder();
        for (int i = strs.length - 1; i >= 0 ; i --) {
            if (!strs[i].equals("")) {
                res.append(strs[i]);
                res.append(" ");
            }
        }

        return res.toString().trim();
    }
}
