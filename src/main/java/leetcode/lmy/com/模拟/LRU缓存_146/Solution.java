package leetcode.lmy.com.模拟.LRU缓存_146;

import java.util.HashMap;

class LRUCache {
    private static class Node {
        int key;
        int value;
        Node pre;
        Node next;
        Node (int k, int v) {
            key = k;
            value = v;
        }
    }

    private final HashMap<Integer, Node> keyToNode = new HashMap<>();
    private final Node dummy = new Node(-1, 0);
    private final int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        dummy.pre = dummy;
        dummy.next = dummy;
    }

    public int get(int key) {
        Node node = getNode(key);
        return node == null ? -1 : node.value;
    }

    public void put(int key, int value) {
        Node node = getNode(key);
        if (node != null) {
            node.value = value;
            return;
        }

        Node tmp = new Node(key, value);
        pushFront(tmp);
        keyToNode.put(key, tmp);

        if (keyToNode.size() > capacity) {
            Node delNode = dummy.pre;
            remove(delNode);
            keyToNode.remove(delNode.key);
        }

    }

    private Node getNode(int key) {
        if (!keyToNode.containsKey(key)) {
            return null;
        }

        Node node = keyToNode.get(key);
        remove(node);
        pushFront(node);

        return node;
    }

    private void remove(Node node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    private void pushFront(Node node) {
        node.pre = dummy;
        node.next = dummy.next;
        dummy.next = node;
        node.next.pre = node;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
