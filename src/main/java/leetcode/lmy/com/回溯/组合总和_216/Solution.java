package leetcode.lmy.com.回溯.组合总和_216;

import java.util.ArrayList;
import java.util.List;

class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {

        dfs(k, n, 1);

        return res;
    }

    public void dfs(int k, int n, int idx) {
        if (path.size() == k) {
            int sum = 0;
            for (int num : path)
                sum += num;
            if (sum == n) res.add(new ArrayList<>(path));

            return;
        }

        for (int i = idx; i <= 9; i ++) {
            path.add(i);
            dfs(k, n, i + 1);
            path.remove(path.size() - 1);
        }
    }
}
