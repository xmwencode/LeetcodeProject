package leetcode.hot100;

class Solution287 {

    public int findDuplicate2(int[] nums) {
        for (int num : nums) {
            int index = Math.abs(num);
            if (nums[index] < 0) {
                return index;
            }
            nums[index] = -nums[index];
        }
        return 0;
    }


    /**
     * Floyd 快慢指针
     */
    public int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        int p1 = 0, p2 = slow;
        while (p1 != p2) {
            p1 = nums[p1];
            p2 = nums[p2];
        }
        return p1;
    }
}