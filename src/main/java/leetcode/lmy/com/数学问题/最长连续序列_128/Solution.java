package leetcode.lmy.com.数学问题.最长连续序列_128;

import java.util.HashSet;

class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int res = 0;
        for (int num : set) {
            int cur = num;
            if (!set.contains(cur - 1)) {
                //说明这个元素是最长序列的头
                while (set.contains(cur + 1)) {
                    cur ++;
                }

                res = Math.max(res, cur - num + 1);
            }
        }

        return res;
    }
}