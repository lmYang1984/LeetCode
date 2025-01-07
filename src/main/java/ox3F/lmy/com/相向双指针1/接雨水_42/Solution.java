package ox3F.lmy.com.相向双指针1.接雨水_42;


class Solution {
    public int trap(int[] height) {
        //每个hi能接到的的水 = Min(leftMax, rightMax) - hi
        int n = height.length;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];
        int preMax = height[0];
        int sufMax = height[n - 1];
        for (int i = 0; i < n; i ++) {
            preMax = Math.max(height[i], preMax);
            leftMax[i] = Math.max(height[i], preMax);
        }
        for (int i = n - 1; i >= 0; i --) {
            sufMax = Math.max(height[i], sufMax);
            rightMax[i] = Math.max(height[i], sufMax);
        }

        int res = 0;
        for (int i = 0; i < n; i ++) {
            if (Math.min(leftMax[i], rightMax[i]) - height[i] > 0) {
                res += Math.min(leftMax[i], rightMax[i]) - height[i];
            }
        }

        return res;
    }

    //相向双指针做法
    public int trap1(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int res = 0;
        int preMax = 0;
        int sufMax = 0;

        while (l < r) {
            preMax = Math.max(preMax, height[l]);
            sufMax = Math.max(sufMax, height[r]);

            if (preMax < sufMax) {
                res += preMax - height[l];
                l ++;
            } else {
                res += sufMax - height[r];
                r --;
            }
        }

        return res;
    }
}
