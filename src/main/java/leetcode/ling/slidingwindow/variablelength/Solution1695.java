package leetcode.ling.slidingwindow.variablelength;

class Solution1695 {
    public int maximumUniqueSubarray(int[] nums) {
        // 不存在重复数字的子数组的数字之和
        int n = nums.length;
        // 记录窗口中字符数量
        int[] cnt = new int[10010];
        int ans = 0;
        int windowSum = 0;
        // 只滑动右端点
        for (int l = 0, r = 0; r < n; r++) {
            // 入端点
            cnt[nums[r]]++;
            windowSum += nums[r];
            // 窗口压缩
            while (cnt[nums[r]] > 1) {
                cnt[nums[l]]--;
                windowSum -= nums[l];
                l++; // 左指针右移
            }
            // 计算
            ans = Math.max(ans, windowSum);
        }
        return ans;
    }
}