package leetcode.lmy.com.模拟.字符串转换整数_8;

public class tmp {

    public int myAtoi(String s) {
        //华为面试算法题
        int len = s.length();
        char[] charArray = s.toCharArray();
        //去掉前导" "
        int idx = 0;
        while (idx < len && charArray[idx] == ' ') {
            idx++;
        }

        //对空串进行特判
        if (idx == len) return 0;

        //判断正负
        boolean isPosetive = true;
        if (charArray[idx] == '+') {
            idx++;
            isPosetive = true;
        } else if (charArray[idx] == '-') {
            idx++;
            isPosetive = false;
        }

        //去掉前导0
        while (idx < len && charArray[idx] == '0') {
            idx++;
        }

        //对0串进行特判
        if (idx == len) return 0;

        //字符串数组转换为numbers
        int res = 0;
        for (int i = idx; i < len; i++) {
            //数字合法判断
            if (charArray[i] >= '0' && charArray[i] <= '9') {
                int number = charArray[i] - '0';
                //范围舍入
                // 题目中说：环境只能存储 32 位大小的有符号整数
                // 需要提前判：断乘以 10 以后是否越界
                if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && charArray[i] > '7')) {
                    return isPosetive == true ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                }
                res = res * 10 + number;

            } else {
                break;
            }
        }

        return isPosetive == true ? res : 0 - res;
    }

}
