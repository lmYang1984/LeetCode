package leetcode.lmy.com.数学问题.多数元素_169;

class Solution {
    public int majorityElement(int[] nums) {
        //摩尔投票法
        int res = nums[0];
        int count = 0;
        for (int i = 0; i < nums.length; i ++) {
            if (count == 0) {
                res = nums[i];
                count ++;
            } else {
                if (nums[i] == res) {
                    count ++;
                } else {
                    count --;
                }
            }
        }

        return res;
    }
}