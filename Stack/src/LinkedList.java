public class LinkedList<E> {

    private class Node {
        public E e;
        public Node next;

        public Node(E e, Node next) { this.e = e; this.next = next; }

        public Node(E e) { this(e, null); }

        public Node() { this(null, null); }

        @Override
        public String toString() { return e.toString(); }
    }

    private Node dummyHead;
    private int size;

    public LinkedList() { dummyHead = new Node(); size = 0; }

    // 获取链表中元素的个数
    public int getSize() { return size; }

    // 返回链表是否为空
    public boolean isEmpty() { return size == 0; }

    // 在链表头添加新元素 e
    public void addFirst(E e) {
        add(e, 0);
    }

    // 在链表的index位置添加新元素e
    // 在链表中不是常用操作,用来练习
    public void add(E e, int index) {
        if (index < 0 || index > size) // 可以等于size, 也就是在链表末尾添加元素
            throw new IllegalArgumentException("LinkedList add failed: illegal index");

        Node prev = dummyHead;
        for (int i = 0; i < index; i++)
            prev = prev.next;
        prev.next = new Node(e, prev.next);
        size ++;
    }

    // 在链表的末尾添加元素e
    public void addLast(E e) { add(e, size); }

    // 获取链表中第 index 个位置的元素
    // 在链表中不是常用操作, 练习用
    public E get(int index) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("LinkedList get failed: illegal index");

        Node current = dummyHead.next;
        for (int i = 0; i < index; i ++)
            current = current.next;
        return current.e;
    }

    // 获取链表第一个元素
    public E getFirst() { return get(0); }

    // 获取链表最后一个元素
    public E getLast() { return get(size - 1); }

    // 设置链表中第 index 个位置元素为新元素 e
    // 在链表中不是常用操作, 练习用
    public void set(E e, int index) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("LinkedList set failed: illegal index");

        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++)
            cur = cur.next;
        cur.e = e;
    }

    // 查找链表中是否有元素 e
    public boolean contains(E e) {
        Node cur = dummyHead.next;
        while (cur != null) {
            if (cur.e.equals(e))
                return true;
            cur = cur.next;
        }
        return false;
    }

    // 删除链表中索引为 index 的元素
    public E remove(int index) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("LinkedList remove failed: illegal index");

        Node prev = dummyHead;
        for (int i = 0; i < index; i ++)
            prev = prev.next;
        Node delNode = prev.next;
        prev.next = delNode.next;
        delNode.next = null;
        size --;
        return delNode.e;
    }

    // 删除链表中第一个元素
    public E removeFirst() { return remove(0); }

    // 删除链表中最后一个元素
    public E removeLast() { return remove(size - 1); }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("LinkedList size=%d\nfront [", size));
        for (Node cur = dummyHead.next; cur != null; cur = cur.next)
            res.append(cur + " -> ");
        res.append("NULL] tail");
        return res.toString();
    }
}
