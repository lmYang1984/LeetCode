package leetcode.lmy.com.数学问题.缺失的第一个正数_41;

public class Solution {
    public int firstMissingPositive(int[] nums) {
        int len = nums.length;
        //nums[i] = i + 1;
        //nums[0] = 1;

        for (int i = 0; i < len; i++) {
            while (nums[i] > 0 && nums[i] < len && nums[i] != nums[nums[i] - 1]) {
                swap(nums, i, nums[i] - 1);
            }
        }

        for (int i = 0; i < len; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        return  len + 1;
    }

    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
