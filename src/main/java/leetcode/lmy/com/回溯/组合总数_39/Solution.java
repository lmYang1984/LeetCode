package leetcode.lmy.com.回溯.组合总数_39;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    int sum = 0;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        //dfs 每层元素都可以任选
        //怎么减枝？
        //sum大于target肯定减
        //candidates[i] > target之后

        Arrays.sort(candidates);//一开始没sort也返回结果了
        dfs(candidates, target, 0);

        return res;
    }

    public void dfs(int[] candidates, int target, int idx) {
        if (sum == target) {
            res.add(new ArrayList<>(path));
            return;
        }
        if (sum > target) return;

        for (int i = idx; i < candidates.length; i ++) {
            sum += candidates[i];
            path.add(candidates[i]);
            dfs(candidates, target, i);
            path.remove(path.size() - 1);
            sum -= candidates[i];
        }
    }
}
