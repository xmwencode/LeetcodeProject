package leetcode.hot100;

import leetcode.utils.ListNode;

class Solution2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode cur = dummyHead;
        int carry = 0;
        while (l1 != null && l2 != null) {
            carry += l1.val + l2.val;
            cur.next = new ListNode(carry % 10);
            cur = cur.next;
            l1 = l1.next;
            l2 = l2.next;
            carry = carry / 10;
        }
        while (l1 != null) {
            carry += l1.val;
            cur.next = new ListNode(carry % 10);
            cur = cur.next;
            l1 = l1.next;
            carry = carry / 10;
        }
        while (l2 != null) {
            carry += l2.val;
            cur.next = new ListNode(carry % 10);
            cur = cur.next;
            l2 = l2.next;
            carry = carry / 10;
        }
        if (carry > 0) {
            cur.next = new ListNode(carry);
        }
        return dummyHead.next;
    }
}