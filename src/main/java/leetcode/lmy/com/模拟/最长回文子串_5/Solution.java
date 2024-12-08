package leetcode.lmy.com.模拟.最长回文子串_5;

class Solution {
    public String longestPalindrome(String s) {
        //用两个数组距离每个位置能够中心扩散的距离
        //用res记录最长的i和扩散的距离
        char[] ss = s.toCharArray();
        int n = ss.length;
        int[] odd = new int[n];
        int[] even = new int[n];
        int resL = -1;
        int resR = -1;
        int res = 0;

        for (int i = 0; i < n; i ++) {
            spreadOdd(i, ss, odd);
            spreadEven(i, ss, even);
            if (odd[i] > res) {
                res = odd[i];
                resL = i - odd[i] / 2;
                resR = i + odd[i] / 2 + 1;
            }
            if (even[i] > res) {
                res = even[i];
                resL = i - even[i] / 2 + 1;
                resR = i + even[i] / 2 + 1;
            }
        }

        return s.substring(resL, resR);
    }

    private void spreadOdd(int i, char[] ss, int[] odd) {
        int l = i;
        int r = i;
        while (l >= 0 && r < ss.length) {
            if (ss[l] == ss[r]) {
                l --;
                r ++;
            } else {
                break;
            }
        }

        odd[i] = r - l - 1;
    }

    private void spreadEven(int i, char[] ss, int[] even) {
        int l = i;
        int r = i + 1;
        while (l >= 0 && r < ss.length) {
            if (ss[l] == ss[r]) {
                l --;
                r ++;
            } else {
                break;
            }
        }

        even[i] = r - l - 1;
    }
}
