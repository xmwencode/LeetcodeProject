package com.xm.leetcode.hot100.linklist;

import java.util.HashMap;
import java.util.Map;

// 146. LRU缓存
class LRUCache {

    private static class Node {
        int key;
        int value;
        Node prev;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private final int capacity;
    private final Node dummy = new Node(0, 0); // 哨兵节点
    private final Map<Integer, Node> map; // 用 O(1) 的时间复杂度查到节点位置

    public LRUCache(int capacity) {
        this.capacity = capacity;
        dummy.next = dummy;
        dummy.prev = dummy;
        map = new HashMap<>();
    }

    public int get(int key) {
        Node node = getNode(key);
        return node == null ? -1 : node.value;
    }

    public void put(int key, int value) {
        // 查询该值，并将它所在的节点放在链表头
        Node node = getNode(key);
        if (node != null) {
            // 存在该值，进行修改
            node.value = value;
            return;
        }
        // 不存在该值，进行插入
        node = new Node(key, value);
        map.put(key, node);
        pushFront(node);
        if (map.size() > capacity) {
            // 移除最末尾的元素，即 dummy 的前一个元素
            Node backNode = dummy.prev;
            map.remove(backNode.key);
            remove(backNode);
        }
    }

    // 查询某个值，并将它所在的节点放在链表头
    private Node getNode(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            // 删除原来的节点
            remove(node);
            // 将该节点放在头部
            pushFront(node);
            return node;
        }
        return null;
    }

    // 在头部添加节点
    private void pushFront(Node node) {
        node.prev = dummy;
        node.next = dummy.next;
        node.prev.next = node;
        node.next.prev = node;
    }

    // 删除链表中的某个节点
    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */