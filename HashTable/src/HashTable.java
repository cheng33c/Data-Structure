import java.util.TreeMap;

public class HashTable<K, V> {

    private TreeMap<K, V>[] hashtable; // 哈希表使用RB树映射构建, K是哈希值, V是另一个TreeMap,里面存储了元素
    private int M; // 哈希表长度
    private int size; // 哈希表的元素数量

    public HashTable(int M1) {
        M = M1;
        size = 0;
        hashtable = new TreeMap[M];
        for (int i = 0; i < M; i ++)
            hashtable[i] = new TreeMap<>();
    }
    public HashTable() { this(97); }


    private int hash(K key) {
        // 得到 key 的hashCode值
        return (key.hashCode() & 0x7fffffff) % M;
    }

    public int getSize() { return size; }

    public void add(K key, V val) {
        TreeMap<K, V> map = hashtable[hash(key)];
        if (!map.containsKey(key))
            size ++;
        map.put(key, val);
    }

    public V remove(K key) {
        TreeMap<K, V> map = hashtable[hash(key)];
        V ret = null;
        if (map.containsKey(key)) {
            ret = map.remove(key);
            size --;
        }
        return ret;
    }

    public void set(K key, V val) {
        TreeMap<K, V> map = hashtable[hash(key)];
        if (!map.containsKey(key))
            throw new IllegalArgumentException("set failed; key doesn't exist!");
        map.put(key, val);
    }

    public boolean contains(K key) { return hashtable[hash(key)].containsKey(key); }

    public V get(K key) { return hashtable[hash(key)].get(key); }
}
