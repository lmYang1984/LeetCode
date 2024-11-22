package leetcode.lmy.com.图.岛屿最大面积_695;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    private static final int[][] DIRECTIONS = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
    int row;
    int col;

    public int maxAreaOfIsland(int[][] grid) {
        row = grid.length;
        col = grid[0].length;
        int maxArea = 0;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    maxArea = Math.max(maxArea, bfs(i, j, grid));
                }
            }
        }

        return maxArea;
    }

    public int bfs(int i, int j, int[][] grid) {
        Deque<int[]> dq = new ArrayDeque<>();
        dq.add(new int[]{i, j});
        grid[i][j] = 0;  // 标记为已访问
        int curArea = 1;

        while (!dq.isEmpty()) {
            int[] point = dq.pollFirst();
            for (int[] direction : DIRECTIONS) {
                int newi = point[0] + direction[0];
                int newj = point[1] + direction[1];
                if (inArea(newi, newj) && grid[newi][newj] == 1) {
                    grid[newi][newj] = 0;  // 标记为已访问
                    dq.addLast(new int[]{newi, newj});
                    curArea++;
                }
            }
        }

        return curArea;
    }

    public boolean inArea(int i, int j) {
        return i >= 0 && i < row && j >= 0 && j < col;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] grid = {
                {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}
        };

        System.out.println(s.maxAreaOfIsland(grid));
    }
}
