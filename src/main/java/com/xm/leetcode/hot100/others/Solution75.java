package com.xm.leetcode.hot100.others;

class Solution75 {
    public void sortColors(int[] nums) {
        int n = nums.length;
        int p0 = 0;  // 下一个应该放置 0 的索引位置
        int p1 = 0;  // 下一个应该放置 1 的索引位置
        for (int i = 0; i < n; i++) {
            int x = nums[i];   // 1. 保存当前元素的值（关键：马上要覆盖原位置）
            nums[i] = 2;       // 2. 先把当前位置强行设为2
            if (x <= 1) {      // 3. 如果当前数是0/1（非2），填充1
                nums[p1++] = 1;
            }
            if (x == 0) {      // 4. 如果当前数是0，填充0
                nums[p0++] = 0;
            }
        }
    }
}