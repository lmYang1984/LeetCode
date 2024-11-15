package leetcode.lmy.com.数学问题.下一个排列_31;

import javax.sound.midi.Soundbank;
import javax.swing.plaf.SliderUI;
import java.util.Arrays;

class Solution {
    public void nextPermutation(int[] nums) {
        //给定若干个数字，将其组合为一个整数。如何将这些数字重新排列，以得到下一个更大的整数。
        //如何保证增加的幅度是最小的呢？
        //找到一个尖角 小 大 降序
        //在[大 降序]中找到一个最小的大
        //swap 中 大 降序 小 降序
        //中 [大 降序 小 降序] 升序
        int i = nums.length - 2;
        int j = nums.length - 1;
        while (i >= 0 && nums[i] >= nums[j]) {
            i --;
            j --;
        }
        if (i == -1) {
            reverse(nums, 0, nums.length - 1);
            return;
        }

        //nums[i] < nums[j];
        for (int swapIdx = nums.length - 1; swapIdx > i ; swapIdx--) {
            if (nums[swapIdx] > nums[i]) {
                swap(nums, swapIdx, i);
                break;
            }
        }

        //将[i + 1, n - 1]区间翻转
        reverse(nums, i + 1, nums.length - 1);
    }

    public void reverse(int[] nums, int l, int r) {
        while (l <= r) {
            int tmp = nums[l];
            nums[l] = nums[r];
            nums[r] = tmp;
            l ++;
            r --;
        }
    }

    public void swap(int[] nums, int l, int r) {
        int tmp = nums[l];
        nums[l] = nums[r];
        nums[r] = tmp;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums1 = new int[]{5,6,4,3,2,1};
        s.nextPermutation(nums1);
        System.out.println(Arrays.toString(nums1));
    }
}