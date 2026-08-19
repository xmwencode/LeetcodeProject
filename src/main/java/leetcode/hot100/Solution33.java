package leetcode.hot100;

class Solution33 {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int left = 0;
        int right = n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            // 与最左侧数字比较判断 mid 位于左有序区间还是右有序区间
            else if (nums[mid] >= nums[left]) {
                // mid 位于左有序区间，且 target 位于 mid 左侧
                if (nums[left] <= target && nums[mid] > target) {
                    right = mid - 1;
                } else {
                    // mid 位于左有序区间，且 target 位于 mid 右侧
                    left = mid + 1;
                }
            } else {
                // mid 位于右有序区间，且 target 位于 mid 右侧
                if (nums[left] > target && nums[mid] < target) {
                    left = mid + 1;
                } else {
                    // mid 位于右有序区间，且 target 位于 mid 左侧
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}
