package leetcode.hot100;

class Solution152 {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        // 前 i 个数的乘积的最大值
        int[] fMax = new int[n + 1];
        // 前 i 个数的乘积的最小值
        int[] fMin = new int[n + 1];
        fMax[0] = fMin[0] = nums[0];
        int res = fMax[0];
        for (int i = 1; i < n; i++) {
            int x = nums[i];
            fMax[i] = Math.max(Math.max(fMax[i - 1] * x, fMin[i - 1] * x), x);
            fMin[i] = Math.min(Math.min(fMax[i - 1] * x, fMin[i - 1] * x), x);
            res = Math.max(res, fMax[i]);
        }
        return res;
    }
}