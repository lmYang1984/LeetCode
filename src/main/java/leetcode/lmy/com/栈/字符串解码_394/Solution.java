package leetcode.lmy.com.栈.字符串解码_394;

import java.util.Stack;

class Solution {
    public String decodeString(String s) {
        Stack<Integer> numStack = new Stack<>();
        Stack<StringBuilder> strStack = new Stack<>();
        StringBuilder res = new StringBuilder();
        char[] ss = s.toCharArray();
        int num = 0;

        for (int i = 0; i < ss.length; i ++) {
            if (Character.isDigit(ss[i])) {
                //若为数字
                num = num * 10 + ss[i] - '0';
            } else if(Character.isLetter(ss[i])) {
                //若为字母
                res.append(ss[i]);
            } else if(ss[i] == '[') {
                //存储decoder前的数字和字符
                numStack.push(num);
                strStack.push(res);
                res = new StringBuilder();
                num = 0;
            } else if(ss[i] == ']') {
                //进行decoder
                //ab12[cd34[ef]]
                int repeat = numStack.pop();
                StringBuilder repeatStr = strStack.pop();
                for (int j = 0; j < repeat; j ++) {
                    repeatStr.append(res);
                }
                res = repeatStr;
            }
        }

        return res.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String encodedString = "3[a2[c]]";
        String decodedString = solution.decodeString(encodedString);
        System.out.println(decodedString); // 输出："accaccacc"
    }
}