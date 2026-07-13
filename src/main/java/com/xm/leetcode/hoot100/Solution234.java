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
class Solution234 {
    public boolean isPalindrome(ListNode head) {
        // 找到中间（或者中间右边）的那个节点
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 翻转链表
        ListNode node = slow;
        ListNode pre = null;
        while (node != null) {
            ListNode nextNode = node.next;
            node.next = pre;
            pre = node;
            node = nextNode;
        }
        ListNode head2 = pre;

        while (head2 != null) {
            if (head.val != head2.val) {
                return false;
            }
            head = head.next;
            head2 = head2.next;
        }
        return true;
    }
}