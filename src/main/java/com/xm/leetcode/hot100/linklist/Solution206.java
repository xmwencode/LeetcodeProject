package com.xm.leetcode.hot100.linklist;

import com.xm.utils.ListNode;

class Solution206 {
    public ListNode reverseList(ListNode head) {
        ListNode node = head;
        // 保存原来指向当前节点的指针
        ListNode pre = null;
        while(node != null) {
            ListNode nextNode = node.next;
            node.next = pre;
            pre = node;
            node = nextNode;
        }
        return pre;
    }
}