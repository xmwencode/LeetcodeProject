package leetcode.hot100;

class Solution4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // 短数组在前
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int n = nums1.length;
        int[] a = new int[n + 2];
        int m = nums2.length;
        int[] b = new int[m + 2];
        // 最左边插入 -∞
        a[0] = b[0] = Integer.MIN_VALUE;
        // 最右边插入 +∞
        a[n + 1] = b[m + 1] = Integer.MAX_VALUE;
        System.arraycopy(nums1, 0, a, 1, n);
        System.arraycopy(nums2, 0, b, 1, m);

        // 枚举 nums1 有 i 个数在第一组
        // 那么 nums2 有 j = (m + n + 1) / 2 - i 个数在第二组
        int i = 0, j = (m + n + 1) / 2;
        while (true) {
            if (a[i] <= b[j + 1] && a[i + 1] > b[j]) {
                int max1 = Math.max(a[i], b[j]);         // 第一组的最大值
                int min2 = Math.min(a[i + 1], b[j + 1]); // 第二组的最小值
                return (m + n) % 2 > 0 ? max1 : (max1 + min2) / 2.0;
            }
            i++;
            j--;
        }
    }
}