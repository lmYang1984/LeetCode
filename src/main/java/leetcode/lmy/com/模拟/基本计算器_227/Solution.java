package leetcode.lmy.com.模拟.基本计算器_227;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;



class Solution {
    HashMap<Character, Integer> map = new HashMap<>(){{
        put('+', 1);
        put('-', 1);
        put('*', 2);
        put('/', 2);
        put('^', 3);
    }};

    public int calculate(String s) {
        s = s.replace(" ", "");
        char[] ss = s.toCharArray();
        int n = ss.length;
        int res = 0;
        Deque<Integer> nums = new ArrayDeque<>();
        Deque<Character> ops = new ArrayDeque<>();
        nums.addFirst(0);

        for (int i = 0; i < n; i++) {
            if (ss[i] == '(') {
                ops.addFirst(ss[i]);
            } else if (ss[i] == ')') {
                //一直计算到'('
                while (!ops.isEmpty()) {
                    if (ops.peekFirst() != '(') {
                        cal(nums, ops);
                    } else {
                        ops.pollFirst();
                        break;
                    }
                }
            } else if (isNumber(ss[i])) {
                int tmpNum = 0;
                while (i < n && isNumber(ss[i])) {
                    tmpNum = tmpNum * 10 + ss[i] - '0';
                    i ++;
                }
                i --;
                nums.addFirst(tmpNum);
            } else if (isOp(ss[i])) {
                //
                if (i > 0 && (ss[i - 1] == '(' || ss[i - 1] == '+' || ss[i - 1] == '-')) {
                    nums.addFirst(0);
                }

                while (!ops.isEmpty() && ops.peekFirst() != '(') {
                    char pre = ops.peekFirst();
                    if (map.get(pre) >= map.get(ss[i])) {
                        cal(nums, ops);
                    } else {
                        break;
                    }
                }

                ops.addFirst(ss[i]);
            }
        }

        while (!ops.isEmpty()) cal(nums, ops);
        return nums.peekFirst();
    }

    private boolean isNumber(char ch) {
        return  ch >= '0' && ch <= '9';
    }

    private boolean isOp(char ch) {
        return map.containsKey(ch);
    }

    private void cal(Deque<Integer> nums, Deque<Character> ops){
        if (nums.isEmpty() || nums.size() < 2) return;
        if (ops.isEmpty()) return;
        int b = nums.pollFirst();
        int a = nums.pollFirst();
        char op = ops.pollFirst();
        int ans = 0;
        if (op == '+') ans = a + b;
        else if (op == '-') ans = a - b;
        else if (op == '*') ans = a * b;
        else if (op == '/')  ans = a / b;
        else if (op == '^') ans = (int)Math.pow(a, b);
        else if (op == '%') ans = a % b;
        nums.addFirst(ans);
    }
}




