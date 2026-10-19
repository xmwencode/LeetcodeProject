package leetcode.ling.slidingwindow.variablelength;

class Solution3258 {
    public int countKConstraintSubstrings(String s, int k) {
        int ans = 0;
        int n = s.length();
        int[] cnt = new int[2];
        for (int l = 0, r = 0; r < n; r++) {
            char c = s.charAt(r);
            cnt[c - '0']++;
            while (cnt[0] > k && cnt[1] > k) {
                cnt[s.charAt(l++) - '0']--;
            }
            ans += r - l + 1;
        }
        return ans;
    }
}