package leetcode.ling.slidingwindow.variablelength;

import java.util.HashMap;
import java.util.Map;

class Solution904 {
    public int totalFruit(int[] fruits) {
        // [1, 2, 3, 3, 2, 4, 4, 5, 6]
        // 当前窗口水果的种类以及数量
        Map<Integer, Integer> cnt = new HashMap<>();
        int n = fruits.length;
        int extra = 0;
        int ans = 0;
        for (int l = 0, r = 0; r < n; r++) {
            if (cnt.getOrDefault(fruits[r], 0) == 0) {
                extra++;
            }
            cnt.merge(fruits[r], 1, Integer::sum);
            while (extra > 2) {
                cnt.merge(fruits[l], -1, Integer::sum);
                if (cnt.get(fruits[l]) == 0) {
                    extra--;
                }
                l++;
            }
            ans = Math.max(ans, r - l + 1);
        }
        return ans;
    }
}