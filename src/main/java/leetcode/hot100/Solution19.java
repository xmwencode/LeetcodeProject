package leetcode.hot100;

import leetcode.utils.ListNode;

class Solution19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return null;
        // 哨兵节点
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode first = head;
        ListNode second = dummyHead;
        // 先让第一个先走 n 步
        for (int i = n; i > 0; i--) {
            first = first.next;
        }
        // 再让第一个和第二个同时走，直到第一个点到达终点
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        // 此时第二个节点的位置即为要删除的节点的位置之前的位置
        second.next = second.next.next;
        return dummyHead.next;
    }
}