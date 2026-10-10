package leetcode.hot100;

class Solution31 {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int i = n - 2;
        // 从右向左，找到最大的数所在的下一个位置
        while (i >= 0 && nums[i] >= nums[i + 1]) i--;
        // [2, 6, 3, 5, 4, 1] 找到下标 i=2，所在的值为 3，后面的 [5, 4, 1] 逆序
        if (i >= 0) {
            // 在逆序 [5, 4, 1] 中找到第一个大于 num[i]=3 的数
            int j = n - 1;
            while (nums[j] <= nums[i]) j--;
            // 交换 num[i]=3 与 num[j]=4
            swap(nums, i, j);
        }
        // 翻转 i+1 到末尾
        reverse(nums, i + 1, n - 1);
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(int[] nums, int l, int r) {
        while (l < r) {
            swap(nums, l++, r--);
        }
    }
}