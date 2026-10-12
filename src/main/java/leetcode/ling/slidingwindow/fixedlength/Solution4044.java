package leetcode.ling.slidingwindow.fixedlength;

class Solution4044 {
    public int countGoodRotations(int[] nums) {
        // 第一个窗口中前 n / 2 个元素的和
        int n = nums.length;
        long firstSum = 0, lastSum = 0;
        int k = n / 2;
        for (int i = 0; i < k; i++) {
            firstSum += nums[i];
            lastSum += nums[k + i];
        }
        int ans = firstSum > lastSum ? 1 : 0;
        // 开始循环移位
        for (int i = 1; i < n; i++) {
            firstSum += nums[(i - 1 + k) % n] - nums[(i - 1) % n];
            lastSum += nums[i - 1] - nums[(i - 1 + k) % n];
            if (firstSum > lastSum) ans++;
        }
        return ans;
    }
}