package leetcode.lmy.com.回溯.组合_77;

import java.util.List;
import java.util.*;

class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        //控制dfs的层高为2
        dfs(n, k, 1);

        return res;
    }

    public void dfs(int n, int k, int idx) {
        if (path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = idx; i <= n; i ++) {
            path.add(i);
            dfs(n, k, i + 1);
            path.remove(path.size() - 1);
        }
    }
}
