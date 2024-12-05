package leetcode.lmy.com.模拟.数组中第k大的元素_215;

class Solution {
    public int findKthLargest(int[] nums, int k) {
        //topK
        //堆排序，然后依次弹出K个元素
        buildHeap(nums);

        int n = nums.length;
        for (int i = n - 1; i >= n - k;) {
            swap(nums, 0, i);

            i --;

            down(nums, 0, i);
        }

        return nums[n - k];
    }

    public void buildHeap(int[] nums) {
        int n = nums.length;
        for (int i = n / 2 - 1; i >= 0; i --) {
            down(nums, i, n - 1);
        }
    }

    public void down(int[] nums, int j, int end) {
        while (j * 2 + 1 <= end) {
            int k = j * 2 + 1;
            if (k + 1 <= end && nums[k + 1] > nums[k]) {
                k ++;
            }

            if (nums[j] < nums[k]) {
                swap(nums, j, k);
            } else {
                break;
            }

            j = k;
        }
    }

    public void swap(int[] nums, int l, int r) {
        int tmp = nums[l];
        nums[l] = nums[r];
        nums[r] = tmp;
    }
}
