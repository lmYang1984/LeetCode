package leetcode.lmy.com.双指针.合并有序数组_88;

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int end = m + n - 1;
        m --;
        n --;
        while (m >= 0 && n >= 0) {
            if (nums1[m] > nums2[n]) {
                nums1[end --] = nums1[m --];
            } else {
                nums1[end --] = nums2[n --];
            }
        }

        while (m >= 0) nums1[end --] = nums1[m --];
        while (n >= 0) nums1[end --] = nums2[n --];
    }
}