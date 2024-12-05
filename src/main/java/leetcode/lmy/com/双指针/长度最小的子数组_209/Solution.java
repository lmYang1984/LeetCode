package leetcode.lmy.com.双指针.长度最小的子数组_209;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        //想法是滑动窗口
        Deque<Integer> dq = new ArrayDeque<>();
        int l = 0;
        int r = 0;
        int windowSum = 0;
        int res = Integer.MAX_VALUE;

        for (; r < nums.length; r ++) {
            dq.addFirst(r);
            windowSum += nums[r];

            while (windowSum >= target) {
                res = Math.min(res, r - dq.peekLast() + 1);

                int out = dq.pollLast();
                windowSum -= nums[out];
            }

        }

        return res == Integer.MAX_VALUE ? 0 : res;
    }
}
