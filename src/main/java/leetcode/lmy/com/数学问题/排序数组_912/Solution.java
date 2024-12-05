package leetcode.lmy.com.数学问题.排序数组_912;

class Solution {
    public int[] sortArray(int[] nums) {
        heapSort(nums);

        return nums;
    }

    public void heapSort(int[] nums) {
        buildHeap(nums);

        for (int i = nums.length - 1; i >= 1;) {
            swap(nums, 0, i);

            i --;

            siftDown(nums, 0, i);
        }
    }

    public void buildHeap(int[] nums) {
        int n = nums.length;
        for (int i = n / 2 - 1; i >= 0; i --) {
            siftDown(nums, i, n - 1);
        }
    }

    public void siftDown(int[] nums, int i, int end) {
        while (i * 2 + 1 <= end) {
            int j = 2 * i + 1;
            if (j + 1 <= end && nums[j + 1] > nums[j]) {
                j ++;
            }

            if (nums[j] > nums[i]) {
                swap(nums, i, j);
            } else {
                break;
            }

            i = j;
        }
    }

    public void swap(int[] nums, int l, int r) {
        int tmp = nums[l];
        nums[l] = nums[r];
        nums[r] = tmp;
    }
}
