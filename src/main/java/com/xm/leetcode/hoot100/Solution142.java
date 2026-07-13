package com.xm.leetcode.hoot100;

import com.xm.leetcode.common.ListNode;

/**
 * 设慢指针从入环到相遇一共走了 b 步, 则快指针走了 2b 步
 * 如果快指针比慢指针多走了 k 圈，每圈长度为 c，则 b = kc
 * 设原点到入环口距离为 a，则入环口到相遇点距离 b - a = kc - a
 * 即从相遇点在走 a 步就能到入环口，恰好等于从原点走 a 步
 */
public class Solution142 {
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        boolean flag = false; // 是否有环
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            // 说明有环，此时快慢指针相交
            if (fast == slow) {
                flag = true;
                break;
            }
        }
        if (!flag) {
            return null;
        }
        // 快指针置为 head 重新跑
        fast = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }
}