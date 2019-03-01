package other;

import java.util.HashMap;
import java.util.Map;

/**
 * @author dengyouquan
 **/
public class LRUCache2<K, V> {
    public static void main(String[] args) {
        LRUCache2<Integer, String> lru = new LRUCache2<>(4);
        lru.set(1, "1");
        lru.set(2, "2");
        lru.set(3, "3");
        lru.set(4, "4");
        lru.set(1, "1");
        lru.set(5, "5");
        System.out.println(lru);
    }


    private int cacheSize;
    private Map<K, Node> map;
    //为了使得头结点和尾结点处理一致
    private Node head;
    private Node tail;

    @SuppressWarnings("unchecked")
    public LRUCache2(int cacheSize) {
        this.cacheSize = cacheSize;
        //+1以免引起扩容
        map = new HashMap<K, Node>((int) (Math.ceil(cacheSize / .75f) + 1), .75f);
        head = new Node(null, null);
        tail = new Node(null, null);
        head.next = tail;
        tail.prev = head;
    }

    @SuppressWarnings("unchecked")
    public void set(K key, V value) {
        Node node = map.get(key);
        //原来有值
        if (node != null) {
            node.val = value;
            map.put(key, node);
            //移除当前节点
            removeNode(node);
            //将当前节点追加到尾部
            appendTail(node);
        } else {
            //如果当前值不存在且达到了size上限
            //需要先移除首部第一个真实节点，再插入节点
            if (map.size() == cacheSize) {
                removeNode(head.next);
            }
            node = new Node(key, value);
            appendTail(node);
            map.put(key, node);
        }
    }

    private void appendTail(Node node) {
        node.next = tail;
        tail.prev.next = node;
        node.prev = tail.prev;
        tail.prev = node;
    }

    public void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    @SuppressWarnings("unchecked")
    public V get(K key) {
        Node node = map.get(key);
        if (node == null) return null;
        removeNode(node);
        appendTail(node);
        return (V) node.val;
    }

    @Override
    public String toString() {
        Node node = head;
        StringBuilder sb = new StringBuilder();
        while ((node = node.next) != tail) {
            sb.append("{");
            sb.append(node.key);
            sb.append(",");
            sb.append(node.val);
            sb.append("}");
        }
        return sb.toString();
    }

    private static class Node<K, V> {
        private Node prev;
        private Node next;
        private K key;
        private V val;

        public Node(K key, V val) {
            this.key = key;
            this.val = val;
        }
    }
}
