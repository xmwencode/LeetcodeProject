package com.xm.leetcode.hoot100;

import com.xm.leetcode.common.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution206 {
    public ListNode reverseList(ListNode head) {
        ListNode node = head;
        // 当前数前面的那个数的指针
        ListNode pre = null;
        while (node != null) {
            ListNode nextNode = node.next;
            node.next = pre;
            pre = node;
            node = nextNode;
        }
        return pre;
    }
}