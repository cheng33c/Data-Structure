public class LinkedListRecursion<E> {
    private class Node {
        public E e;
        public Node next;

        public Node(E e, Node next) { this.e = e; this.next = next; }
        public Node(E e) { this.e = e; this.next = null; }
        public Node() {this.e = null; this.next = null; }

        @Override
        public String toString() { return e.toString(); }
    }

    private Node dummyHead;
    private int size;

    LinkedListRecursion() {
        dummyHead = new Node();
        size = 0;
    }

    public void add(E e, int index) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException(
                    String.format("add failed; index is illegal, SIZE=%d, INDEX=%d", size, index));
        addRecursion(e, dummyHead, -1, index);
    }

    private void addRecursion(E e, Node cur, int cur_idx, int index) {
        if (cur_idx == index - 1) {
            cur.next = new Node(e, cur.next);
            size ++;
        }
        else
            addRecursion(e, cur.next, cur_idx + 1, index);
    }

    public void addFirst(E e) { add(e, 0); }
    public void addLast(E e) { add(e, size); }

    public E get(int index) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException(
                    String.format("get failed; index is illegal, SIZE=%d, INDEX=%d", size, index));
        return getRecursion(dummyHead.next, 0, index);
    }

    private E getRecursion(Node cur, int cur_idx, int index) {
        if (cur_idx == index)
            return cur.e;
        return getRecursion(cur.next, cur_idx + 1, index);
    }

    public E getFirst() { return get(0); }
    public E getLast() { return get(size); }

    public void set(E e, int index) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException(
                    String.format("set failed; index is illegal, SIZE=%d, INDEX=%d", size, index));
        setRecursion(e, dummyHead.next, 0, index);
    }

    private void setRecursion(E e, Node cur, int cur_idx, int index) {
        if (cur_idx != index)
            setRecursion(e, cur.next, cur_idx + 1, index);
        cur.e = e;
    }

    public void setFirst(E e) { set(e, 0); }
    public void setLast(E e) { set(e, size - 1); }

    public boolean contains(E e) {
        return containsRecursion(e, dummyHead.next);
    }

    private boolean containsRecursion(E e, Node cur) {
        if (cur == null)
            return false;
        if (cur.e == e)
            return true;
        return containsRecursion(e, cur.next);
    }

    public E remove(int index) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException(
                    String.format("remove failed; index is illegal, SIZE=%d, INDEX=%d", size, index));
        return removeRecursion(dummyHead, -1, index);
    }

    private E removeRecursion(Node cur, int cur_idx, int index) {
        if (cur_idx == index - 1) {
            Node delNode = cur.next;
            cur.next = delNode.next;
            delNode.next = null;
            size--;
            return delNode.e;
        }
        return removeRecursion(cur.next, cur_idx + 1, index);
    }

    public E removeFirst() { return remove(0); }
    public E removeLast() { return remove(size - 1); }


    public int getSize() { return size; }
    public boolean isEmpty() { return size == 0; }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("LinkedListRecursion: size=%d\n", size));
        for (Node cur = dummyHead.next; cur != null; cur = cur.next) {
            sb.append(cur.e + "->");
        }
        sb.append("NULL");
        return sb.toString();
    }
}
