package leetcode.lmy.com.图.岛屿的数量_200;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    private int[][] dir = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1},};
    private Deque<int[]> dq = new ArrayDeque<>();
    private int res = 0;

    public int numIslands(char[][] grid) {
        //dq + bfs
        int m = grid[0].length;
        int n = grid.length;
        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < m; j ++) {
                if (grid[i][j] == '1') {
                    bfs(grid, i, j);
                    res ++;
                }
            }
        }

        return res;
    }

    private void bfs(char[][] grid, int i, int j) {
        int[] p = new int[2];
        p[0] = i;
        p[1] = j;

        dq.add(p);
        while (!dq.isEmpty()) {
            int[] point = dq.pollFirst();
            int pi = point[0];
            int pj = point[1];
            for (int k = 0; k < 4; k ++) {
                int newi = pi + dir[k][0];
                int newj = pj + dir[k][1];
                if (inMap(grid,newi, newj) && grid[newi][newj] == '1') {
                    grid[newi][newj] = '0';
                    dq.add(new int[]{newi, newj});
                }
            }
        }
    }

    private boolean inMap(char[][] grid, int i, int j) {
        int n = grid[0].length;
        int m = grid.length;
        return i >= 0 && i < m && j >= 0 && j < n;
    }
}