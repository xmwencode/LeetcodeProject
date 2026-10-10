package leetcode.hot100;

class Solution169 {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        int res = 0, count = 0;
        for (int x : nums) {
            if (count == 0) {
                res = x;
                count = 1;
            } else {
                count += x == res ? 1 : -1;
            }
        }
        return res;
    }
}