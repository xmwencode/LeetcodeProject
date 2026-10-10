package leetcode.ling.slidingwindow.fixedlength;

class Solution1343 {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int n = arr.length;
        int ans = 0;
        int sum = 0;
        int target = k * threshold;

        for (int i = 0; i < n; i++) {
            // 入端点
            sum += arr[i];
            int l = i - k + 1;
            if (l < 0) continue;

            // 更新答案
            if (sum >= target) {
                ans++;
            }
            // 出端点
            sum -= arr[l];
        }
        return ans;
    }
}