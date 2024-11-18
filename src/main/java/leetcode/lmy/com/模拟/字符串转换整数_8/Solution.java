package leetcode.lmy.com.模拟.字符串转换整数_8;

public class Solution {

    public int myAtoi(String s) {
        int len = s.length();
        char[]  chArr = s.toCharArray();

        //去除空串' '
        int idx = 0;
        while (idx < len && chArr[idx] == ' ') {
            idx ++;
        }

        //空串进行特判
        if (idx == len) return 0;

        //判断正负
        boolean isPosetive = true;
        if (chArr[idx] == '+') {
            idx ++;
            isPosetive = true;
        } else if (chArr[idx] == '-') {
            idx ++;
            isPosetive = false;
        }

        //去掉前导0
        while (idx < len && chArr[idx] == '0') {
            idx++;
        }

        //对0串进行特判
        if (idx == len) return 0;

        int res = 0;

        for (int i = idx; i < len; i++) {
            if (chArr[i] >= '0' && chArr[i] <= '9') {
                int num = chArr[i] - '0';
                if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && num > 7)) {
                    return  isPosetive == true ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                }

                res = res * 10 + num;
            } else {
                break;
            }
        }

        return isPosetive == true ? res : 0 - res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.myAtoi("981734589"));
    }
}
