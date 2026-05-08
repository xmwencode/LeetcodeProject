package com.xm.leetcode.everyday;

import java.util.*;

class Solution3629 {

    private static final int MAXN = 1_000_000;
    public static boolean[] isPrime = new boolean[MAXN];

    // 初始化质数表
    static {
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        for (int i = 2; i * i <= MAXN; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j < MAXN; j += i) {
                    isPrime[j] = false;
                }
            }
        }
    }

    // 获取质数表 例如将 60 分解为 2 3 5
    private List<Integer> getPrimeList(int n) {
        List<Integer> primeList = new ArrayList<>();
        if (n <= 1) return primeList;
        // 先处理 2
        if (n % 2 == 0) {
            primeList.add(2);
            while (n % 2 == 0) {
                n /= 2;
            }
        }
        // 在从 3 开始处理奇数质因数
        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0) {
                primeList.add(i);
                while (n % i == 0) {
                    n /= i;
                }
            }
        }
        // 处理剩余的最后一个质数
        if (n > 1) primeList.add(n);
        return primeList;
    }

    public int minJumps(int[] nums) {
        int n = nums.length;
        if (n <= 1) return 0;
        // 预处理所有质因数列表
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            if (num <= 1) continue;
            List<Integer> factors = getPrimeList(num);
            for (Integer factor : factors) {
                // 生成预处理表，注意存储的是下标
                map.computeIfAbsent(factor, k -> new ArrayList<>()).add(i);
            }
            // 可能会出现相同的数组，所以添加自己本身
            map.computeIfAbsent(num, k -> new ArrayList<>()).add(i);
        }
        // 开始 bfs
        boolean[] visited = new boolean[n];
        Deque<Map.Entry<Integer, Integer>> queue = new ArrayDeque<>();
        queue.offer(Map.entry(0, 0));
        visited[0] = true;
        while (!queue.isEmpty()) {
            Map.Entry<Integer, Integer> curr = queue.poll();
            int index = curr.getKey(), step = curr.getValue();

            // 向前跳
            if (index + 1 < n && !visited[index + 1]) {
                // 出口
                if (index + 1 == n - 1) return step + 1;
                visited[index + 1] = true;
                queue.offer(Map.entry(index + 1, step + 1));
            }
            // 向后跳
            if (index - 1 >= 0 && !visited[index - 1]) {
                if (index - 1 == n - 1) return step + 1;
                visited[index - 1] = true;
                queue.offer(Map.entry(index - 1, step + 1));
            }
            // 向质数跳
            int p = nums[index];
            if (p > 1 && p <= MAXN && isPrime[p]) {
                // 以当前质数 p 为因数的集合在 nums 中的下标
                List<Integer> primeList = map.getOrDefault(p, Collections.emptyList());
                // 可以抵达的下标
                for (Integer j : primeList) {
                    if (!visited[j] && j != index) {
                        if (j == n - 1) return step + 1;
                        visited[j] = true;
                        queue.offer(Map.entry(j, step + 1));
                    }
                }
            }
        }
        return -1;
    }
}