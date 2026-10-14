package leetcode.ling.slidingwindow.variablelength;

class Solution1493 {
    public int longestSubarray(int[] nums) {
        // [0,1,1,1,0,1,1,0,1]
        int ans = 0;
        int n = nums.length;
        // 当前出现的 0 的数量
        int count = 0;
        for (int l = 0, r = 0; r < n; r++) {
            if (nums[r] == 0) count++;
            while (count > 1) {
                if (nums[l++] == 0) count--;
            }
            ans = Math.max(ans, r - l);
        }
        return ans;
    }
}