package leetcode.lmy.com.模拟.最大数_179;

import java.util.Arrays;

class Solution {
    public String largestNumber(int[] nums) {
        int n = nums.length;
        String[] strNums = new String[n];
        for (int i = 0; i < n; i ++) {
            strNums[i] = Integer.toString(nums[i]);
        }

        Arrays.sort(strNums, (a, b) -> {
            String order1 = a + b;
            String order2 = b + a;
            return order2.compareTo(order1);
        });

        if (strNums[0].charAt(0) == '0') return "0";

        StringBuilder res = new StringBuilder();
        for (String str : strNums) {
            res.append(str);
        }

        return res.toString();
    }
}