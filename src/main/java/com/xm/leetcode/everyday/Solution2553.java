package com.xm.leetcode.everyday;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution2553 {
    public int[] separateDigits(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int n = nums.length;
        for (int i = n - 1; i >= 0; i--) {
            int num = nums[i];
            while(num > 0) {
                res.add(num % 10);
                num /= 10;
            }
        }
        Collections.reverse(res);
        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}