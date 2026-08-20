package leetcode.hot100;

class Solution45 {
    public int jump(int[] nums) {
        // 全局最远可以到达的最远点
        int maxJump = 0;
        // 当前这次跳跃可以到达的最远点
        int curJump = 0;
        int res = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            maxJump = Math.max(maxJump, i + nums[i]);
            // 当前最远只能到达当前点，直接跳一次到达全局最远点
            if (curJump == i) {
                curJump = maxJump;
                res++;
            }
        }
        return res;
    }

}