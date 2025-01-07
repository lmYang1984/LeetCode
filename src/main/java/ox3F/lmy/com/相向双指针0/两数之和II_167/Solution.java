package ox3F.lmy.com.相向双指针0.两数之和II_167;

/**
 * 原本是n方的复杂度
 * 但是因为数组有序
 * 有些情况以及被排除掉了
 * 你看一开始的l和r，当sum大于tar的时候，其实这时候对于r来说已经找不出一个更小的l组成tar自然可以直接排除
 */

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int l = 0;
        int r = numbers.length - 1;
        int[] res = new int[2];
        while (l <= r) {
            int sum = numbers[l] + numbers[r];
            if (sum > target) {
                r --;
            } else if (sum < target) {
                l ++;
            } else {
                return new int[]{l+1, r+1};
            }
        }

        return res;
    }
}