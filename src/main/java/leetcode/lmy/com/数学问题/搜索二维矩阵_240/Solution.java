package leetcode.lmy.com.数学问题.搜索二维矩阵_240;

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;

        int i = 0;
        int j = col - 1;
        while (i >= 0 && i < row && j >= 0 && j < col) {
            if (matrix[i][j] > target) {
                j --;
            } else if (matrix[i][j] < target) {
                i ++;
            } else {
                return true;
            }
        }

        return false;
    }
}
