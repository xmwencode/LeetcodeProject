package leetcode.hot100;

import java.util.ArrayList;
import java.util.List;

class Solution22 {
    public List<String> generateParenthesis(int n) {
        // 一共 2n 个位置，n 个位置上放左括号，n 个位置上放右括号
        List<String> res = new ArrayList<>();
        StringBuilder path = new StringBuilder();
        dfs(0, 0, n, path, res);
        return res;
    }

    /**
     * @param left  当前放置的左括号数量
     * @param right 当前放置的右括号数量
     * @param n     一共的括号对数
     * @param path  当前放置的括号串
     * @param res   结果集
     */
    private void dfs(int left, int right, int n, StringBuilder path, List<String> res) {
        // 有效括号：生成到当前位置时【右括号的数量不能大于左括号的数量】
        if (right >= n) {
            res.add(new String(path));
            return;
        }
        if (left < n) {
            // 可以放置 '('
            path.append('(');
            dfs(left + 1, right, n, path, res);
            path.deleteCharAt(path.length() - 1);
        }
        if (left > right) {
            // 可以放置 ')'
            path.append(')');
            dfs(left, right + 1, n, path, res);
            path.deleteCharAt(path.length() - 1);
        }
    }
}