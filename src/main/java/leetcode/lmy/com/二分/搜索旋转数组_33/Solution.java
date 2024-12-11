package leetcode.lmy.com.二分.搜索旋转数组_33;

class Solution {
    public int search(int[] nums, int target) {
        //在两段升序的序列中找到目标值
        //找到第一段的end
        int l = 0;
        int r = nums.length - 1;
        int cp = nums[nums.length - 1];

        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] > cp) {
                l = mid + 1;//mid在第一段
            } else {
                r = mid - 1;
            }
        }
        //[0, l - 1] [l, r]

        int l1 = 0;
        int r1 = l - 1;
        while (l1 <= r1) {
            int mid = l1 + (r1- l1) / 2;
            if (nums[mid] > target) {
                r1 = mid - 1;
            } else if (nums[mid] < target) {
                l1 = mid + 1;
            } else {
                return mid;
            }
        }

        int l2 = l;
        int r2 = nums.length - 1;
        while (l2 <= r2) {
            int mid = l2 + (r2- l2) / 2;
            if (nums[mid] > target) {
                r2 = mid - 1;
            } else if (nums[mid] < target) {
                l2 = mid + 1;
            } else {
                return mid;
            }
        }

        if (l2 == nums.length) return -1;
        return nums[l2] == target ? l2 : -1;
    }
}