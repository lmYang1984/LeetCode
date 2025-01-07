package ox3F.lmy.com.相向双指针.统计和小于目标的下标对数目_2824;

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
