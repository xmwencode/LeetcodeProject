package com.xm.leetcode.hot100.linklist;

/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

import com.xm.utils.Node;

class Solution138 {
    public Node copyRandomList(Node head) {
        // 复制每个节点到原节点的后面
        for (Node cur = head; cur != null; cur = cur.next.next) {
            Node newNode = new Node(cur.val);
            newNode.next = cur.next;
            cur.next = newNode;
        }
        // 遍历交错链表中的原链表节点
        for (Node cur = head; cur != null; cur = cur.next.next) {
            if (cur.random != null) {
                cur.next.random = cur.random.next;
            }
        }
        // 链表奇偶分离
        Node dummy = new Node(0);
        Node tail = dummy;
        for (Node cur = head; cur != null; cur = cur.next) {
            Node copy = cur.next;
            tail.next = copy;
            cur.next = copy.next;
            tail = tail.next;
        }
        return dummy.next;
    }
}