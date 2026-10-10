package leetcode.ling.slidingwindow.fixedlength;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution2841 {
    public long maxSum(List<Integer> nums, int m, int k) {
        // 记录当前窗口的元素以及数量
        Map<Integer, Integer> cnt = new HashMap<>();
        // 记录当前窗口的元素种类数量
        int size = 0;
        // 记录当前子数组的和
        long sum = 0;
        // 记录历史最大和
        long ans = 0;

        int n = nums.size();
        for (int i = 0; i < n; i++) {
            // 入端点
            if (cnt.getOrDefault(nums.get(i), 0) == 0) {
                size++;
            }
            cnt.merge(nums.get(i), 1, Integer::sum);
            sum += nums.get(i);
            int l = i - k + 1;
            if (l < 0) continue;

            // 计算
            if (size >= m) {
                ans = Math.max(ans, sum);
            }

            // 出端点
            sum -= nums.get(l);
            cnt.merge(nums.get(l), -1, Integer::sum);
            if (cnt.get(nums.get(l)) == 0) {
                size--;
            }
        }
        return ans;
    }
}