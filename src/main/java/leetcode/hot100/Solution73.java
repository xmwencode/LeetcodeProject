package leetcode.hot100;

class Solution73 {
    public void setZeroes(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        // 标记第0行是否存在 0
        boolean firstRowZero = false;
        for (int i = 0; i < m; i++) {
            if (matrix[0][i] == 0) {
                firstRowZero = true;
                break;
            }
        }
        // 用第1行/第0列来记录当前行/列是否存在0
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }
        // 将 [1~n-1][1~m-1] 用 0 填充
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        // 第0列填充 0
        if (matrix[0][0] == 0) {
            for (int i = 1; i < n; i++) {
                matrix[i][0] = 0;
            }
        }
        // 第0行填充 0
        if (firstRowZero) {
            for (int i = 0; i < m; i++) {
                matrix[0][i] = 0;
            }
        }
    }
}