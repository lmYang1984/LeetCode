package ox3F.lmy.com.相向双指针1.盛最多水的容器_11;

import java.util.Collections;
import java.util.List;

class Solution {
    public int countPairs(List<Integer> nums, int target) {
        Collections.sort(nums);
        int l = 0;
        int r = nums.size() - 1;
        int cnt = 0;

        while (l <= r) {
            int sum = nums.get(l) + nums.get(r);
            if (sum < target) {
                cnt = cnt + (r - l);
                l ++;
            } else {
                r --;
            }
        }

        return cnt;
    }
}
