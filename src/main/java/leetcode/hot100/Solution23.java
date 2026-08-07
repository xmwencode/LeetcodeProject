package leetcode.hot100;

import leetcode.utils.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

class Solution23 {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));
        ListNode dummyHead = new ListNode(0);
        ListNode cur = dummyHead;
        for (ListNode list : lists) {
            if (list != null) {
                queue.add(list);
            }
        }
        while (!queue.isEmpty()) {
            ListNode node = queue.poll();
            if (node.next != null) {
                queue.offer(node.next);
            }
            cur.next = node;
            cur = cur.next;
        }
        return dummyHead.next;
    }
}