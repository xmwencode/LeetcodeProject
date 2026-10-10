package leetcode.hot100;

class Solution75 {
    public void sortColors(int[] nums) {
        // 把数组分成三个区间
        // [0, low)    全部是 0
        // [low, i)    全部是 1
        // [i, high]   待处理区域
        // (high, n-1] 全部是 2

        // low:  0 区域的右边界
        int low = 0;
        // high: 2 区域的左边界
        int high = nums.length - 1;
        int i = 0;
        while (i <= high) {
            if (nums[i] == 0) {
                // 当前是 0，交换到 low 位置，low 和 i 都右移
                swap(nums, low++, i++);
            } else if (nums[i] == 2) {
                // 当前是 2，交换到 high 位置，high 左移
                swap(nums, i, high--);
            } else {
                // 当前是 1，不需要交换
                i++;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}