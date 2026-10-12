package leetcode.ling.slidingwindow.fixedlength;

import java.util.Arrays;

class Solution2134 {
    public int minSwaps(int[] nums) {
        int n = nums.length;
        int k = Arrays.stream(nums).sum();
        if (k == 0) return 0;
        // 寻找一个长度为 k 的子窗口使窗口里的 1 的数量最多即可
        int win = 0;
        int ans = 0;
        for (int i = 0; i < n + k - 1; i++) {
            // 滚动数组
            win += nums[i % n];
            int l = i - k + 1;
            if (l < 0) continue;
            ans = Math.max(ans, win);
            win -= nums[l % n];
        }
        return k - ans;
    }

    public int minSwaps2(int[] nums) {
        int n = nums.length;
        int k = Arrays.stream(nums).sum();
        if (k == 0) return 0;
        // 寻找一个长度为 k 的子窗口使窗口里的 1 的数量最多即可
        int win = 0;
        int ans = 0;
        // 双倍数组模拟滚动
        int[] newNums = new int[2 * n + 1];
        for (int i = 0; i < n; i++) {
            newNums[i] = newNums[i + n] = nums[i];
        }
        for (int i = 0; i < newNums.length; i++) {
            win += newNums[i];
            int l = i - k + 1;
            if (l < 0) continue;
            ans = Math.max(ans, win);
            win -= newNums[l];
        }
        return k - ans;
    }
}