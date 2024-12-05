package leetcode.lmy.com.模拟.快排_912;

import java.util.Random;

class Solution {
    private final Random rd = new Random();
    public int[] sortArray(int[] nums) {

        quick_sort(nums, 0, nums.length - 1);

        return nums;
    }

    public void quick_sort(int[] nums, int l, int r) {
        if (l >= r) return;

        swap(nums, l, l + rd.nextInt(r - l + 1));

        int i = l;
        int j = r;
        while (i < j) {
            while (i < j && nums[j] >= nums[l]) j --;
            while (i < j && nums[i] <= nums[l]) i ++;
            swap(nums, i, j);
        }
        swap(nums, i, l);

        quick_sort(nums, l, i - 1);
        quick_sort(nums, i + 1, r);
    }

    public void swap(int[] nums, int l, int r) {
        int tmp = nums[l];
        nums[l] = nums[r];
        nums[r] = tmp;
    }
}