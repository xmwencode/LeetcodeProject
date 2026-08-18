package leetcode.hot100;

import java.util.ArrayList;
import java.util.List;

class Solution17 {
    private static String[] dirt = new String[]{
            "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
    };

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        StringBuilder path = new StringBuilder();
        dfs(digits, 0, path, res);
        return res;
    }

    private void dfs(String nums, int u, StringBuilder path, List<String> res) {
        if (u >= nums.length()) {
            res.add(path.toString());
            return;
        }
        int digit = nums.charAt(u) - '0';
        for (char c : dirt[digit].toCharArray()) {
            path.append(c);
            dfs(nums, u + 1, path, res);
            path.deleteCharAt(path.length() - 1);
        }
    }
}