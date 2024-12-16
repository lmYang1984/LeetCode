package leetcode.lmy.com.模拟.合并区间_53;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> {
            if (o1[0] != o2[0])
                return o1[0] - o2[0];
            else
                return o1[1] - o2[1];
        });

        List<int[]> res = new ArrayList<>();
        int[] cur = new int[2];
        cur[0] = intervals[0][0];
        cur[1] = intervals[0][1];

        for (int i = 1; i < intervals.length; i ++) {
            int l = cur[0];
            int r = cur[1];
            if(r >= intervals[i][0] && r <= intervals[i][1]) {
                cur[1] = intervals[i][1];
            } else if (r < intervals[i][0]) {
                res.add(new int[]{cur[0], cur[1]});
                cur[0] = intervals[i][0];
                cur[1] = intervals[i][1];
            }
        }

        res.add(new int[]{cur[0], cur[1]});

        // 将 List<List<Integer>> 转换为 int[][]
        return res.toArray(new int[res.size()][]);
    }


}
