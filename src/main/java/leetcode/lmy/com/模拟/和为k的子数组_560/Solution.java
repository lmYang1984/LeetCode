package leetcode.lmy.com.模拟.和为k的子数组_560;

import java.util.HashMap;

class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int pre = 0;
        int res = 0;

        for (int i = 0; i < nums.length; i ++) {
            pre = pre + nums[i];
            //前面有几个这样的前缀，i处就可以有几个子数组组成k
            int target = pre - k;

            if (map.containsKey(target)) {
                res += map.get(target);
            }

            map.put(pre, map.getOrDefault(pre, 0) + 1);
        }

        return res;
    }
}
