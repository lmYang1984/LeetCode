package leetcode.lmy.com.回溯.括号生成_22;

import java.util.ArrayList;
import java.util.List;

class Solution {
    List<String> res = new ArrayList<>();
    StringBuilder path = new StringBuilder();

    public List<String> generateParenthesis(int n) {
        backTracking(n, 0, 0);

        return res;
    }

    public void backTracking(int n, int l, int r) {
        if (l == n && r == n && path.length() == n * 2) {
            res.add(new String(path));
            return;
        }

        if (l > n || r > n) return;

        if (l < n) {
            path.append("(");
            backTracking(n, l + 1, r);
            path.deleteCharAt(path.length() - 1);
        }

        if (r < l) {
            path.append(")");
            backTracking(n, l, r + 1);
            path.deleteCharAt(path.length() - 1);
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        //System.out.println(s.generateParenthesis(1));
        //System.out.println(s.generateParenthesis(2));
        //System.out.println(s.generateParenthesis(3));
        //System.out.println(s.generateParenthesis(4));
        System.out.println(s.generateParenthesis(5));
    }
}