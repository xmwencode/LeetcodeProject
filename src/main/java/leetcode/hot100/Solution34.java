package leetcode.hot100;

class Solution34 {
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        int first = binarySearchFirst(nums, target);
        if (first >= n || first < 0 || nums[first] != target) {
            return new int[]{-1, -1};
        }
        int last = binarySearchLast(nums, target);
        return new int[]{first, last};
    }

    /**
     * 闭区间写法寻找元素出现的第一个位置
     */
    private int binarySearchFirst(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    /**
     * 闭区间写法寻找元素出现的最后一个位置
     * 可以看作寻找第一个位置的 left 与 right 置换以下
     * 也可以看做寻找 binarySearchFirst(int[], int + 1) - 1
     */
    private int binarySearchLast(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return right;
    }
}