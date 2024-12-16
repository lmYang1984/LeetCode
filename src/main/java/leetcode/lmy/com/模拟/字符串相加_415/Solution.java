package leetcode.lmy.com.模拟.字符串相加_415;

class Solution {
    public String addStrings(String num1, String num2) {
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int carry = 0;
        StringBuilder res = new StringBuilder();

        while (i >= 0 || j >= 0) {
            int a = i >= 0 ? num1.charAt(i) - '0' : 0;
            int b = j >= 0 ? num2.charAt(j) - '0' : 0;
            int cur = a + b + carry;
            carry = cur / 10;
            res.append(cur % 10);
            i --;
            j --;
        }
        if (carry != 0) res.append(carry);

        return res.reverse().toString();
    }
}
