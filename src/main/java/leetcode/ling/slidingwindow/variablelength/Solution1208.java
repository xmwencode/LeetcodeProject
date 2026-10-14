package leetcode.ling.slidingwindow.variablelength;

class Solution1208 {
    public int equalSubstring(String S, String T, int maxCost) {
        char[] s = S.toCharArray();
        char[] t = T.toCharArray();
        int n = s.length;
        int ans = 0;
        int cost = 0;
        for (int l = 0, r = 0; r < n; r++) {
            cost += Math.abs(s[r] - t[r]);
            while(cost > maxCost) {
                cost -= Math.abs(s[l] - t[l]);
                l++;
            }
            ans = Math.max(ans, r - l + 1);
        }
        return ans;
    }
}