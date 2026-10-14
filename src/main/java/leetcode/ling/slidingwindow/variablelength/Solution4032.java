package leetcode.ling.slidingwindow.variablelength;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution4032 {

    private static int MX = 100_010;
    private static List<Integer>[] primes = new ArrayList[MX];

    static {
        // 预处理质因数
        Arrays.setAll(primes, i -> new ArrayList<>());
        for (int i = 2; i < MX; i++) {
            if (primes[i].isEmpty()) { // i 是质数
                for (int j = i; j < MX; j += i) {
                    primes[j].add(i);
                }
            }
        }
    }

    public int longestSubarray(int[] nums, int k) {

        int n = nums.length;
        int[] cnt = new int[MX];
        int ans = 0;
        int seed = 0;
        for (int l = 0, r = 0; r < n; r++) {
            for (Integer num : primes[nums[r]]) {
                if (cnt[num] == 0) seed++;
                cnt[num]++;
            }
            while (seed > k) {
                for (Integer num : primes[nums[l]]) {
                    int c = --cnt[num];
                    if (c == 0) seed--;
                }
                l++;
            }
            ans = Math.max(ans, r - l + 1);
        }
        return ans;
    }
}