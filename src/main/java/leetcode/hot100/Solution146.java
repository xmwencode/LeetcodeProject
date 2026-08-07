package leetcode.hot100;

import java.util.HashMap;
import java.util.Map;

public class Solution146 {

    static class LRUCache {

        static class Node {
            int key;
            int value;
            Node prev;
            Node next;

            Node(int key, int value) {
                this.key = key;
                this.value = value;
            }
        }

        // 容量
        int capacity = 0;
        // 哨兵节点
        Node dummyHead = new Node(Integer.MAX_VALUE, -1);
        // 存储节点值 -> 节点的映射
        Map<Integer, Node> map = new HashMap<>();

        public LRUCache(int capacity) {
            dummyHead.prev = dummyHead;
            dummyHead.next = dummyHead;
            this.capacity = capacity;
        }

        public int get(int key) {
            Node node = getAndSetLeatestNode(key);
            return node == null ? -1 : node.value;
        }

        public void put(int key, int value) {
            Node node = getAndSetLeatestNode(key);
            if (node != null) {
                node.value = value;
                return;
            }
            node = new Node(key, value);
            // 新节点插入哈希表
            map.put(key, node);
            // 新节点插入链表头
            putNodeToFront(node);
            // 超出容量去除最后一个节点
            if (map.size() > capacity) {
                Node backNode = dummyHead.prev;
                map.remove(backNode.key);
                remove(backNode);
            }
        }

        /**
         * 将节点插入到链表头部
         */
        private void putNodeToFront(Node node) {
            node.prev = dummyHead;
            node.next = dummyHead.next;
            dummyHead.next.prev = node;
            dummyHead.next = node;
        }

        /**
         * 获取对应的节点并移动到链表头部
         */
        private Node getAndSetLeatestNode(int key) {
            if (!map.containsKey(key)) {
                return null;
            }
            Node node = map.get(key);
            remove(node);
            putNodeToFront(node);
            return node;
        }

        private void remove(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
    }

}
