package leetcode.lmy.com.双指针.最小覆盖子串_76;



import java.util.HashMap;

class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";
        char[] ss = s.toCharArray();
        char[] tt = t.toCharArray();

        HashMap<Character, Integer> need = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();
        for (char a : tt)
            need.put(a, need.getOrDefault(a, 0) + 1);

        int l = 0;
        int r = 0;
        int valid = 0;
        int res = Integer.MAX_VALUE;
        int idx = 0;
        for (; r < ss.length; r++) {
            if (need.containsKey(ss[r])) {
                window.put(ss[r], window.getOrDefault(ss[r], 0) + 1);
                if (window.get(ss[r]).equals(need.get(ss[r]))) {
                    valid++;
                }
            }

            while (valid >= need.size()) {
                if (res > r - l + 1) {
                    res = r - l + 1;
                    idx = l;
                }

                if (need.containsKey(ss[l])) {
                    if (window.get(ss[l]).equals(need.get(ss[l])))
                        valid --;
                    window.put(ss[l], window.get(ss[l]) - 1);
                }

                l ++;
            }
        }

        return  res == Integer.MAX_VALUE ? "" : s.substring(idx, idx + res);
    }
}