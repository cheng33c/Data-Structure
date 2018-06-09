public class LoopLinkedList<E> {
    private class Node {
        public E e;
        public Node prev, next;
        public Node() { this.e = null; this.next = null; }
        public Node(E e) { this.e = e; this.next = null; }
        public Node(E e, Node prev, Node next) { this.e = e; this.prev = prev; this.next = next; }
        @Override
        public String toString() { return e.toString(); }
    }

    private Node dummyHead;
    private int size;

    public LoopLinkedList() {
        dummyHead = new Node();
        dummyHead.prev = dummyHead.next = dummyHead;
        int size = 0;
    }

    public void add(E e, int index) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException(
                    String.format("add failed; index illegal. SIZE=%d, INDEX=%d", size, index));

        Node prevNode = dummyHead;
        if (index > size / 2) {
            // 大于一半的长度,从dummyHead向前搜索(.prev), 要多搜索一位才能到达前驱节点
            for (int i = 0; i <= size - index; i ++, prevNode = prevNode.prev)
                ;
        } else {
            // 小等于一半长度,从dummyHead向后搜索,不用多搜索一位
            for (int i = 0; i < index; i ++)
                prevNode = prevNode.next;
        }
        Node newNode = new Node(e, prevNode, prevNode.next);
        prevNode.next = newNode;
        newNode.next.prev = newNode;
        size ++;
    }
    public void addFirst(E e) { add(e, 0); }
    public void addLast(E e) { add(e, size); }


    public void set(E e, int index) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException(
                    String.format("set failed; index illegal. SIZE=%d, INDEX=%d", size, index));

        Node cur = dummyHead;
        if (index > size / 2) {
            for (int i = 0; i < size - index; i++)
                cur = cur.prev;
        } else {
            for (int i = 0; i <= index; i ++)
                cur = cur.next;
        }
        cur.e = e;
    }
    public void setFirst(E e) { set(e, 0); }
    public void setLast(E e) { set(e, size-1); }

    public E remove(int index) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException(
                    String.format("remove failed; index illegal. SIZE=%d, INDEX=%d", size, index));

        Node prevNode = dummyHead;
        if (index > size / 2) {
            for (int i = 0; i <= size - index; i ++, prevNode = prevNode.prev)
                ;
        } else {
            for (int i = 0; i < index; i ++)
                prevNode = prevNode.next;
        }
        Node delNode = prevNode.next;
        delNode.next.prev = prevNode;
        prevNode.next = delNode.next;
        delNode.prev = delNode.next = null;
        size --;
        return delNode.e;
    }
    public E removeFirst() { return remove(0); }
    public E removeLast() { return remove(size-1); }

    public E get(int index) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException(
                    String.format("remove failed; index illegal. SIZE=%d, INDEX=%d", size, index));

        Node cur = dummyHead.next;
        if (index > size / 2) {
            for (int i = 0; i < size - index + 1; i ++, cur = cur.prev)
                ;
        } else {
            for (int i = 0; i < index; i ++, cur = cur.next)
                ;
        }
        return cur.e;
    }
    public E getFirst() { return get(0); }
    public E getLast() { return get(size-1); }

    public boolean contains(E e) {
        Node cur = dummyHead.next;
        for (int i = 0; i < size; i ++, cur = cur.next)
            if (cur.e.equals(e))
                return true;
        return false;
    }

    public int getSize() { return size; }
    public boolean isEmpty() { return size == 0; }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node cur = dummyHead.next;
        sb.append(String.format("LoopLinkedList: SIZE=%d\n", size));
        for (int i = 0; i < size; i ++, cur = cur.next) {
        	sb.append(cur.e);    
		sb.append(" -> ");
	}
        sb.append("NULL");
        return sb.toString();
    }
}
