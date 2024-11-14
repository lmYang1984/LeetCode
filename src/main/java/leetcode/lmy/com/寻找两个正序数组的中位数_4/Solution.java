package leetcode.lmy.com.寻找两个正序数组的中位数_4;

public class Solution {
    /**
     * 首先这题是想在a数组确定一个位置i，相应的在b数组也就确定了一个j，从而将整个数组左边划分出了(m + n + 1) / 2个元素
     * i 表示数组 a 的分割点，即将 a 分为 a[0]...a[i] 和 a[i+1]...a[m-1]。
     * j 是与 i 对应的分割点，表示数组 b 分割为 b[0]...b[j] 和 b[j+1]...b[n-1]。

     * 那么考虑二分a[i]跳转的条件是什么呢？
     * 我们最终的效果是实现
     * a[left] <= b[j+1]      b[j+1]为右部的第一个元素
     * a[right] > b[j+1]
     */
    public double findMedianSortedArrays(int[] a, int[] b) {
        //确保a数组是更短的那个
        if (a.length > b.length) {
            int[] tmp = a;
            a = b;
            b = tmp;
        }

        int m = a.length;
        int n = b.length;

        int left = -1;//a[left] <= b[j+1]
        int right = m;//a[right] > b[j+1]

        while(left + 1 < right) {
            int i = (left + right) / 2;// i 表示数组 a 的分割点，即将 a 分为 a[0]...a[i] 和 a[i+1]...a[m-1]。
            int j = (m + n + 1) / 2 - 2 - i;//j 是与 i 对应的分割点，表示数组 b 分割为 b[0]...b[j] 和 b[j+1]...b[n-1]。

            if (a[i] <= b[j + 1] || j + 1 == n) {
                left = i;//
            } else {
                right = i;
            }
        }

//     * i 表示数组 a 的分割点，即将 a 分为 a[0]...a[i] 和 a[i+1]...a[m-1]。
//     * j 是与 i 对应的分割点，表示数组 b 分割为 b[0]...b[j] 和 b[j+1]...b[n-1]。
        int i = left;
        int j = (m + n + 1) / 2 - 2 - i;
        int leftMax1 = i >= 0 ? a[i] : Integer.MIN_VALUE;
        int leftMax2 = j >= 0 ? b[j] : Integer.MIN_VALUE;
        int leftMax = Math.max(leftMax1, leftMax2);
        int rightMin1 = i + 1 < m ? a[i + 1] : Integer.MAX_VALUE;
        int rightMin2 = j + 1 < n ? b[j + 1] : Integer.MAX_VALUE;
        int rightMin = Math.min(rightMin1, rightMin2);
        return  (m + n) % 2 == 1 ? leftMax : (leftMax + rightMin) / 2.0;
    }
}
