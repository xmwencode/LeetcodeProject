package leetcode.hot100;

class Solution74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        int left = 0;
        int right = n * m - 1;

        // 闭区间上的写法
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int x = matrix[mid / m][mid % m];
            if (x == target) {
                return true;
            } else if (x < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }

}