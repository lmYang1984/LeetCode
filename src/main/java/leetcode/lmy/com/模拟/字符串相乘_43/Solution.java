package leetcode.lmy.com.模拟.字符串相乘_43;

class Solution {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) return "0";
        char[] ss = num1.toCharArray();
        char[] tt = num2.toCharArray();
        int m = ss.length;
        int n = tt.length;
        int[] res = new int[m + n];
        for (int i = m - 1; i >= 0; i --) {
            for (int j = n - 1; j >= 0; j --) {
                int num = (ss[i] - '0') * (tt[j] - '0');
                int p1 = i + j;
                int p2 = i + j + 1;
                int sum = num + res[p2];
                res[p2] = sum % 10;
                res[p1] += sum / 10;
            }
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < res.length; i++) {
            if (res[i] == 0 && i == 0){
                continue;
            }

            result.append(res[i]);
        }

        return result.toString();
    }
}
