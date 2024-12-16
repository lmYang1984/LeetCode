package leetcode.lmy.com.模拟.螺旋矩阵_53;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;

        int up = 0;
        int down = m - 1;
        int left = 0;
        int right = n - 1;

        while (true) {
            for (int j = left; j <= right; j ++) {
                res.add(matrix[up][j]);
            }
            if (++up > down) break;

            for (int i = up; i <= down; i ++) {
                res.add(matrix[i][right]);
            }
            if (left > --right) break;

            for (int j = right; j >= left; j --) {
                res.add(matrix[down][j]);
            }
            if (up > --down) break;

            for (int i = down; i >= up; i --) {
                res.add(matrix[i][left]);
            }
            if (++left > right) break;
        }

        return res;
    }
}