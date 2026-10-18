package leetcode.ling.slidingwindow.variablelength;

class Solution713 {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) return 0;
        int n = nums.length;
        int ans = 0;
        long mul = 1;
        for (int l = 0, r = 0; r < n; r++) {
            mul *= nums[r];
            while (mul >= k) {
                mul /= nums[l++];
            }
            ans += r - l + 1;
        }

        return ans;
    }
}