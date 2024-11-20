package leetcode.lmy.com.二分.在排序数组中查找元素的第一个和最后一个位置_34;

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        //找到leftIdx，
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        //r + 1 = l
        if (l >= nums.length || nums[l] != target) {
            res[0] = -1;
            res[1] = -1;
            return res;
        }
        res[0] = l;

        l = 0;
        r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] <= target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        if (l != res[0])
            res[1] = l - 1;
        else
            res[1] = res[0];

        return res;
    }
}