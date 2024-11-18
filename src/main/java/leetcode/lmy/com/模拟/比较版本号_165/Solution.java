package leetcode.lmy.com.模拟.比较版本号_165;

public class Solution {
    public int compareVersion(String version1, String version2) {
        char[]  ch1 = version1.toCharArray();
        char[]  ch2 = version2.toCharArray();
        int p1 = 0;
        int p2 = 0;

        while (p1 < version1.length() || p2 < version2.length()) {
            int v1number = 0;
            for (; p1 < version1.length(); p1++) {
                if (ch1[p1] != '.') {
                    int tmp = ch1[p1] - '0';
                    v1number = v1number * 10 + tmp;
                } else {
                    p1 ++;
                    break;
                }
            }

            int v2number = 0;
            for (; p2 < version2.length(); p2++) {
                if (ch2[p2] != '.') {
                    int tmp = ch2[p2] - '0';
                    v2number = v2number * 10 + tmp;
                } else {
                    p2 ++;
                    break;
                }
            }

            if (v1number != v2number) {
                return  v1number > v2number ? 1 : -1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.compareVersion("1.1", "1.2"));
    }
}
