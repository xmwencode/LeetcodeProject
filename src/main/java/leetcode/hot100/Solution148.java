package leetcode.hot100;

import leetcode.utils.ListNode;

class Solution148 {
    public ListNode sortList(ListNode head) {
        // 归并排序
        if (head == null || head.next == null) {
            return head;
        }
        ListNode prev = findMiddlePrev(head);
        ListNode middle = prev.next;
        prev.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(middle);
        return mergeList(left, right);
    }

    // 1. 寻找链表的中间节点（偶节点返回左节点）
    public ListNode findMiddlePrev(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    // 2. 链表有序合并
    public ListNode mergeList(ListNode head1, ListNode head2) {
        ListNode dummyHead = new ListNode(0);
        ListNode cur = dummyHead;
        ListNode l1 = head1;
        ListNode l2 = head2;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        if (l1 != null) {
            cur.next = l1;
        }
        if (l2 != null) {
            cur.next = l2;
        }
        return dummyHead.next;
    }

}