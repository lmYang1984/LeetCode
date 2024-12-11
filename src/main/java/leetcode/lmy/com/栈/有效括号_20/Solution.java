package leetcode.lmy.com.栈.有效括号_20;

import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        char[] ss = s.toCharArray();

        for (int i = 0; i < ss.length; i ++) {
            if (ss[i] == '(') {
                st.push(')');
            } else if (ss[i] == '{') {
                st.push('}');
            } else if (ss[i] == '[') {
                st.push(']');
            } else {
                if (st.isEmpty()) return false;

                char ch = st.pop();
                if (ch != ss[i]) return false;
            }
        }

        return st.isEmpty() == true ? true : false;
    }
}