package ox3F.lmy.com.相向双指针.有效三角形的个数_611;

import java.util.Arrays;

class Solution {
    public int triangleNumber(int[] nums) {
        //三角形满足条件
        //a + b > c
        Arrays.sort(nums);
        int n = nums.length;
        int res = 0;
        //只有a+b是单调的，可以用双指针去判断
        for (int i = 2; i < n; i ++) {

            int l = 0;
            int r = i - 1;
            while (l < r) {
                if (nums[l] + nums[r] > nums[i]) {
                    res = res + (r - l);
                    r --;
                } else {
                    l ++;
                }
            }
        }

        return res;
    }
}
