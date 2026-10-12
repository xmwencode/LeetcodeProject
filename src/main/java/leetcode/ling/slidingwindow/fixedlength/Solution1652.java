package leetcode.ling.slidingwindow.fixedlength;

class Solution1652 {
    public int[] decrypt(int[] code, int k) {
        int n = code.length;
        int[] ans = new int[n];
        if (k == 0) return ans;
        // 解决环形数组越界
        int[] arr = new int[2 * n];
        System.arraycopy(code, 0, arr, 0, n);
        System.arraycopy(code, 0, arr, n, n);
        int win = 0;
        int winSize = Math.abs(k);
        int left = k > 0 ? 1 : n - winSize;

        // 初始窗口和
        for (int i = 0; i < winSize; i++) {
            win += arr[i + left];
        }
        ans[0] = win;
        // 滑动窗口
        for (int i = 1; i < n; i++) {
            win = win - arr[left] + arr[left + winSize];
            ans[i] = win;
            left++;
        }

        return ans;
    }
}