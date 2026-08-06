package leetcode.hot100;

import leetcode.utils.ListNode;

class Solution234 {
    public boolean isPalindrome(ListNode head) {
        // 寻找链表的中间节点
        ListNode mid = middleNode(head);
        // 翻转链表
        ListNode rev = reverseList(mid);
        while (rev != null) {
            if (head.val != rev.val) {
                return false;
            }
            head = head.next;
            rev = rev.next;
        }
        return true;
    }

    private ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private ListNode reverseList(ListNode head) {
        if (head == null) return null;
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}