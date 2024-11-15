package leetcode.lmy.com.二分.二分查找_704;

class Solution {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        //闭区间二分[l, r]
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] < target) {
                l = mid + 1;
            } else if (nums[mid] > target) {
                r = mid - 1;
            } else {
                return mid;
            }
        }
        //l - 1 = r

        return l < nums.length && nums[l] == target ? l : -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // 测试用例 1: 目标值存在于数组中
        int[] nums1 = {-1, 0, 3, 5, 9, 12};
        int target1 = 9;
        int result1 = solution.search(nums1, target1);
        System.out.println("Test Case 1: Expected: 4, Actual: " + result1);

        // 测试用例 2: 目标值不存在于数组中
        int[] nums2 = {-1, 0, 3, 5, 9, 12};
        int target2 = 2;
        int result2 = solution.search(nums2, target2);
        System.out.println("Test Case 2: Expected: -1, Actual: " + result2);

        // 测试用例 3: 目标值是数组的第一个元素
        int[] nums3 = {-1, 0, 3, 5, 9, 12};
        int target3 = -1;
        int result3 = solution.search(nums3, target3);
        System.out.println("Test Case 3: Expected: 0, Actual: " + result3);

        // 测试用例 4: 目标值是数组的最后一个元素
        int[] nums4 = {-1, 0, 3, 5, 9, 12};
        int target4 = 12;
        int result4 = solution.search(nums4, target4);
        System.out.println("Test Case 4: Expected: 5, Actual: " + result4);

        // 测试用例 5: 数组为空
        int[] nums5 = {};
        int target5 = 12;
        int result5 = solution.search(nums5, target5);
        System.out.println("Test Case 5: Expected: -1, Actual: " + result5);
    }
}
