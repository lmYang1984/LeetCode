package leetcode.lmy.com.二分.寻找峰值_162;

class Solution {
    public int findPeakElement(int[] nums) {
        //两个先验
        //一个是边上的值为负无穷
        //用大小递推到边界，使得一定有峰值
        int l = 0;
        int r = nums.length - 2;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] < nums[mid + 1]) {
                //说明[mid + 1, n - 1]有峰值
                l = mid + 1;
            } else {
                //说明[0, mid]有峰值,此时错过了mid
                //若mid为峰值之后l == r时必然有nums[r] < nums[r + 1] l会重新指向res
                //和r = n - 1一样
                r = mid - 1;
            }
        }
        //[2, 3, 1, 5]
        //l = 0; r = 2; mid = 1
        //r = 0; 发现l == r的时候不是,

        return l;
    }
}
