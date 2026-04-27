package com.xm.leetcode.hot100.linklist;

import com.xm.utils.ListNode;

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
class Solution148 {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        // 找到中间节点，进行分治排序
        ListNode middle = middleNode(head);
        // 分治
        ListNode left = sortList(head);
        ListNode right = sortList(middle);
        // 合并两个有序链表
        return mergeTwoLists(left, right);
    }

    /**
     * 合并两个有序链表：双指针
     */
    private ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // 哨兵节点
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                cur.next = list1;
                list1 = list1.next;
            } else {
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
        }
        cur.next = list1 == null ? list2 : list1;
        return dummy.next;
    }

    /**
     * 寻找链表的中间节点：快慢指针法 时间复杂度 O(n)
     */
    private ListNode middleNode(ListNode head) {
        ListNode pre = head;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        // 断开 slow 的前一个节点和 slow 的连接
        pre.next = null;
        return slow;
    }
}