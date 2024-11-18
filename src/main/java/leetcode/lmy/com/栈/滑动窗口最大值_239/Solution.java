package leetcode.lmy.com.栈.滑动窗口最大值_239;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        int[] res = new int[len - k + 1];

        Deque<Integer> window = new ArrayDeque<>();

        for (int i = 0; i < len; i++) {
            while (!window.isEmpty() && nums[i] >= nums[window.peekFirst()]) {
                window.pollFirst();
            }
            window.addFirst(i);

            while (i - window.peekLast() + 1 > k) {
                window.pollLast();
            }

            if (i > k - 1) res[i - k + 1] = nums[window.peekLast()];
        }

        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        //s.maxSlidingWindow();
    }
}