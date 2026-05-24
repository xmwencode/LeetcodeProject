package com.xm.leetcode.everyday;

class Solution1340 {

    public int maxJumps(int[] arr, int d) {
        int n = arr.length;
        // 计算 arr[i] 左边最近的更大的元素的下标 left[i]
        int[] left = new int[n];
        // 维护单调递减栈，栈中存储下标
        int[] st = new int[n];
        int top = -1;
        for (int i = 0; i < n; i++) {
            int x = arr[i];
            // 所有比当前数小的数下标全部出栈
            while (top >= 0 && arr[st[top]] <= x) {
                top--;
            }
            // 左边没有更大的数，或者超出了最大跳跃距离 d，就标记为 -1
            if (top < 0 || i - st[top] > d) {
                left[i] = -1;
            } else {
                left[i] = st[top];
            }
            // 当前下标入栈
            st[++top] = i;
        }

        // 计算 arr[i] 右边最近的更大的元素的下标 right[i]
        int[] right = new int[n];
        top = -1;
        for (int i = n - 1; i >= 0; i--) {
            int x = arr[i];
            // 所有比当前数小的数下标全部出栈
            while (top >= 0 && arr[st[top]] <= x) {
                top--;
            }
            // 右边没有更大的数，或者超出了最大跳跃距离 d，就标记为 -1
            if (top < 0 || st[top] - i > d) {
                right[i] = -1;
            } else {
                right[i] = st[top];
            }
            // 当前下标入栈
            st[++top] = i;
        }

        int ans = 0;
        int[] cnt = new int[n];
        // 倒着跳，从低到高
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, dfs(i, left, right, cnt));
        }

        return ans;
    }

    private int dfs(int i, int[] left, int[] right, int[] cnt) {
        if (i < 0) return 0;
        if (cnt[i] > 0) return cnt[i];
        int res = 1;
        // 往左跳
        res = Math.max(res, dfs(left[i], left, right, cnt) + 1);
        // 往右跳
        res = Math.max(res, dfs(right[i], left, right, cnt) + 1);
        cnt[i] = res;
        return res;
    }


    public int maxJumps1(int[] arr, int d) {
        int n = arr.length;
        // 记忆化数组，计算从 i 开始跳能访问的最多下标数量
        int[] cnt = new int[n];
        // 枚举起点
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, dfs1(i, d, arr, cnt));
        }
        return ans;
    }

    private int dfs1(int i, int d, int[] arr, int[] cnt) {
        // 之前计算过
        if (cnt[i] > 0) return cnt[i];
        int res = 1;
        // 向左跳
        for (int j = i - 1; j >= Math.max(i - d, 0) && arr[i] > arr[j]; j--) {
            res = Math.max(res, dfs1(j, d, arr, cnt) + 1);
        }
        // 向右跳
        for (int j = i + 1; j <= Math.min(i + d, arr.length - 1) && arr[i] > arr[j]; j++) {
            res = Math.max(res, dfs1(j, d, arr, cnt) + 1);
        }
        cnt[i] = res;
        return res;
    }
}