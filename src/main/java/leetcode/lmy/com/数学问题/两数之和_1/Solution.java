package leetcode.lmy.com.数学问题.两数之和_1;

import  java.util.HashMap;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i ++) {
            int find = target - nums[i];
            if (map.containsKey(find)) {
                res[0] = map.get(find);
                res[1] = i;
                return res;
            }
            map.put(nums[i], i);
        }

        return res;
    }
}
