import java.util.ArrayList;

public class BSTMap<K extends Comparable<K>, V> implements Map<K, V> {
    private class Node {
        public K key;
        public V value;
        public Node left, right;
        public Node(K key1, V value1) { key = key1; value = value1; right = left = null; }
        @Override
        public String toString() { return key.toString() + " : " + value.toString(); }
    }

    private Node root;
    private int size;

    public BSTMap() { root = null; size = 0; }

    @Override
    public int getSize() { return size; }
    @Override
    public boolean isEmpty() { return size == 0; }

    @Override
    public void add(K key, V value) { root = add(root, key, value); }
    private Node add(Node node, K key, V value) {
        if (node == null) {
            size ++;
            return new Node(key, value);
        }
        int cmp = key.compareTo(node.key);
        if (cmp < 0)
            node.left = add(node.left, key, value);
        else if (cmp > 0)
            node.right = add(node.right, key, value);
        else // cmp == 0 更新value
            node.value = value;
        return node;
    }

    // 返回以 node 为根节点的二分搜索树中 key 所在的节点
    private Node getNode(Node node, K key) {
        if (node == null)
            return null;
        int cmp = key.compareTo(node.key);
        if (cmp < 0)
            return getNode(node.left, key);
        else if (cmp > 0)
            return getNode(node.right, key);
        else // cmp == 0
            return node;
    }

    @Override
    public boolean contains(K key) { return getNode(root, key) != null; }

    @Override
    public V get(K key) {
        Node node = getNode(root, key);
        return node == null ? null : node.value;
    }

    @Override
    public void set(K key, V value) {
        Node node = getNode(root, key);
        if (node == null)
            throw new IllegalArgumentException(key + " doesn't exist!");
        node.value = value;
    }

    // 返回以 node 为根的二分搜索树的最小值所在的节点
    private Node minimum(Node node) {
        if (node.left == null)
            return node;
        return minimum(node.left);
    }
    // 删除以node为根的二分树的最小节点,返回删除后更新的二分树的根
    private Node removeMin(Node node) {
        if (node.left == null) {
            Node rightNode = node.right;
            node.right = null;
            size --;
            return rightNode;
        }
        node.left = removeMin(node.left);
        return node;
    }

    @Override
    public V remove(K key) { return remove(root, key).value; }
    private Node remove(Node node, K key) {
        if (node == null)
            return null;
        int cmp = key.compareTo(node.key);
        if (cmp < 0) return (node.left = remove(node.left, key));
        else if (cmp > 0) return (node.right = remove(node.right, key));
        else {
            if (node.left == null) {
                Node rightNode = node.right;
                node.right = null;
                return rightNode;
            }
            else if (node.right == null) {
                Node leftNode = node.left;
                node.left = null;
                return leftNode;
            }
            else { // node.left != null && node.right != null
                node.key = minimum(node.right).key;
                node.right = removeMin(node.right);
                return node;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("pride-and-prejudice");

        ArrayList<String> words = new ArrayList<>();
        if (FileOperation.readFile("pride-and-prejudice.txt", words)) {
            System.out.println("Total words: " + words.size());
            BSTMap<String, Integer> map = new BSTMap<>();
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
