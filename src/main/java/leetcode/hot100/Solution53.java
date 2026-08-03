package leetcode.hot100;

class Solution53 {
    public int maxSubArray(int[] nums) {
        int cur = -0x3f3f3f3f;
        int max = -0x3f3f3f3f;
        for (int num : nums) {
            cur = Math.max(cur + num, num);
            max = Math.max(cur, max);
        }
        return max;
    }
}