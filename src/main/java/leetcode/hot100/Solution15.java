package leetcode.hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < n - 2; i++) {
            int x = nums[i];
            // 跳过重复数字
            if (i > 0 && x == nums[i - 1]) continue;
            int l = i + 1, r = n - 1;
            while (l < r) {
                int sum = x + nums[l] + nums[r];
                if (sum == 0) {
                    int second = nums[l];
                    int third = nums[r];
                    // 符合条件
                    res.add(Arrays.asList(x, second, third));
                    // 去重
                    while (l < r && nums[l] == second) l++;
                    while (l < r && nums[r] == third) r--;
                } else if (sum > 0) {
                    r--;
                } else {
                    l++;
                }
            }
        }
        return res;
    }
}