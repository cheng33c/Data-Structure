public class DoubleLinkedList<E> {

    private class Node {
        public E e;
        public Node prev, next;
        public Node() { this.e = null; this.prev = null; this.next = null; }
        public Node(E e) { this.e = e; this.prev = null; this.next = null; }
        public Node(E e, Node prev, Node next) { this.e = e; this.prev = prev; this.next = next;}
        @Override
        public String toString() { return e.toString(); }
    }

    private Node dummyHead;
    private int size;

    public DoubleLinkedList() {
        dummyHead = new Node();
        size = 0;
    }

    public void add(E e, int index) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException(
                    String.format("add failed. index is illegal. SIZE=%d, INDEX=%d", size, index));

        Node prevNode = dummyHead;
        for (int i = 0; i < index; i ++)
            prevNode = prevNode.next;
        Node newNode = new Node(e, prevNode, prevNode.next);
        prevNode.next = newNode;
        if (newNode.next != null)
            newNode.next.prev = newNode;
        size ++;
    }
    public void addFirst(E e) { add(e, 0); }
    public void addLast(E e) { add(e, size); }


    public E get(int index) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException(
                    String.format("get failed. index is illegal. SIZE=%d, INDEX=%d", size, index));

        Node cur = dummyHead.next;
        for (int i = 0; i < index; i ++)
            cur = cur.next;
        return cur.e;
    }
    public E getFirst() { return get(0); }
    public E getLast() { return get(size-1); }


    public void set(E e, int index) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException(
                    String.format("set failed. index is illegal. SIZE=%d, INDEX=%d", size, index));

        Node cur = dummyHead.next;
        for (int i = 0; i <= index; i ++)
            cur = cur.next;
        cur.e = e;
    }
    public void setFirst(E e) { set(e, 0); }
    public void setLast(E e) { set(e, size-1); }


    public E remove(int index) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException(
                    String.format("remove failed. index is illegal. SIZE=%d, INDEX=%d", size, index));

        Node prevNode = dummyHead;
        for (int i = 0; i < index; i ++, prevNode = prevNode.next)
            ;
        Node delNode = prevNode.next;
        if (delNode.next != null) {
            prevNode.next = delNode.next;
            delNode.next.prev = delNode.prev;
        }
        delNode.prev = delNode.next = null;
        size --;
        return delNode.e;
    }
    public E removeFirst() { return remove(0); }
    public E removeLast() { return remove(size-1); }


    public boolean contains(E e) {
        Node cur = dummyHead.next;
        for (int i = 0; i < size; i ++, cur = cur.next)
            if (cur.e == e)
                return true;
        return false;
    }

    public int getSize() { return size; }
    public boolean isEmpty() { return size == 0; }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node cur = dummyHead.next;
        sb.append(String.format("DoubleLinkedList size=%d\n", size));
        for (int i = 0; i < size; i ++, cur = cur.next)
            sb.append(String.format("%d -> ", cur.e));
        sb.append("NULL");
        return sb.toString();
    }
}
