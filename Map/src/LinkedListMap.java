import java.util.ArrayList;

public class LinkedListMap<K, V> implements Map<K, V> {

    private class Node {
        public K key;
        public V value;
        public Node next;
        public Node(K key1, V value1, Node next1) { key = key1; value = value1; next = next1; }
        public Node(K key) { this(key, null, null); }
        public Node() { this(null, null, null); }
        @Override
        public String toString() { return key.toString() + " : " + value.toString(); }
    }


    private Node dummyHead;
    private int size;

    public LinkedListMap() { dummyHead = new Node(); size = 0; }

    @Override
    public int getSize() { return size; }
    @Override
    public boolean isEmpty() { return size == 0; }

    private Node getNode(K key) {
        for (Node cur = dummyHead.next; cur != null; cur = cur.next)
            if (key.equals(cur.key))
                return cur;
        return null;
    }

    @Override
    public boolean contains(K key) { return getNode(key) != null; }

    @Override
    public V get(K key) {
        Node node = getNode(key);
        return node == null ? null : node.value;
    }

    @Override
    public void add(K key, V value) {
        Node node = getNode(key);
        if (node == null) {
            dummyHead.next = new Node(key, value, dummyHead.next);
            size ++;
        }
        else
            node.value = value;
    }

    @Override
    public void set(K key, V value) {
        Node node = getNode(key);
        if (node == null)
            throw new IllegalArgumentException(node.key + " doesn't exist!");
        node.value = value;
    }

    @Override
    public V remove(K key) {
        Node prev = dummyHead;
        for (; prev.next != null; prev = prev.next)
            if (key.equals(prev.next.key))
                break;
        if (prev.next != null) {
            Node delNode = prev.next;
            prev.next = delNode.next;
            delNode.next = null;
            size --;
            return delNode.value;
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println("pride-and-prejudice");

        ArrayList<String> words = new ArrayList<>();
        if (FileOperation.readFile("pride-and-prejudice.txt", words)) {
            System.out.println("Total words: " + words.size());
            LinkedListMap<String, Integer> map = new LinkedListMap<>();
            for (String word : words) {
                if (map.contains(word))
                    map.set(word, map.get(word) + 1);
                else
                    map.add(word, 1);
            }
            System.out.println("Total different words: " + map.getSize());
            System.out.println("Frequency of PRIDE: " + map.get("pride"));
            System.out.println("Frequency of PREJUDICE: " + map.get("prejudice"));
        }
    }

}
