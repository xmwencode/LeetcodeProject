package leetcode.hot100;

import leetcode.utils.ListNode;

class Solution25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        // 统计节点个数
        int n = 0;
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        for (ListNode cur = head; cur != null; cur = cur.next) {
            n++;
        }
        ListNode pre = null;
        ListNode cur = dummyHead.next;
        ListNode p = dummyHead;
        // k 个一组翻转链表
        while (n >= k) {
            int cnt = 0;
            while (cnt++ < k && cur != null) {
                ListNode next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
            }
            // 将翻转的链表链接在哨兵节点上
            p.next.next = cur;
            ListNode nextList = p.next;
            p.next = pre;
            p = nextList;
            n -= k;
        }
        return dummyHead.next;
    }
}