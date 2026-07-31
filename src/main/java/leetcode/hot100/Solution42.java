package leetcode.hot100;

class Solution42 {

    public int trap(int[] height) {
        int n = height.length;
        int l = 0, r = n - 1;
        int leftMax = 0; // 保存左侧的最大值
        int rightMax = 0; // 保存右侧的最大值
        int ans = 0;
        while (l < r) {
            leftMax = Math.max(leftMax, height[l]);
            rightMax = Math.max(rightMax, height[r]);
            if (leftMax >= rightMax) {
                ans += rightMax - height[r];
                r--;
            } else {
                ans += leftMax - height[l];
                l++;
            }
        }
        return ans;
    }

    public int trap2(int[] height) {
        int n = height.length;
        // 计算左侧最大值列表
        int[] leftMax = new int[n];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i - 1]);
        }
        // 计算右侧最大值列表
        int[] rightMax = new int[n];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i + 1]);
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += Math.max(0, Math.min(leftMax[i], rightMax[i]) - height[i]);
        }
        return ans;
    }
}