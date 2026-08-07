package leetcode.hot100;

class Solution138 {

    public static class Node {
        public int val;
        public Node next;
        public Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        // 复制原节点到每个节点的后面
        for (Node cur = head; cur != null; cur = cur.next.next) {
            Node copy = new Node(cur.val);
            copy.next = cur.next;
            cur.next = copy;
        }
        // 更新复制节点 random 节点的指向
        for (Node cur = head; cur != null; cur = cur.next.next) {
            if (cur.random != null) {
                cur.next.random = cur.random.next;
            }
        }
        // 奇偶节点分离
        Node dummyHead = new Node(0);
        dummyHead.next = head;
        Node copyHead = dummyHead;
        for (Node cur = head; cur != null; cur = cur.next) {
            Node copy = cur.next;
            copyHead.next = copy;
            cur.next = copy.next;
            copyHead = copyHead.next;
        }
        return dummyHead.next;
    }
}