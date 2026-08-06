package leetcode.hot100;

class Solution238 {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        res[0] = 1;
        // 左前缀积
        for (int i = 1; i < n; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }
        // 右前缀积
        int mul = 1;
        for (int i = n - 1; i > 0; i--) {
            mul *= nums[i];
            res[i - 1] *= mul;
        }

        return res;
    }
}