package leetcode.ling.slidingwindow.variablelength;

class Solution1004 {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int ans = 0;
        // 操作次数
        int op = 0;
        // 变成连续的 1
        for (int l = 0, r = 0; r < n; r++) {
            if (nums[r] == 0) op++;
            while (op > k) {
                if (nums[l++] == 0) op--;
            }
            ans = Math.max(ans, r - l + 1);
        }
        return ans;
    }
}