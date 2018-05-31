public class LinkedListQueue<E> implements Queue<E> {

    private class Node {
        public E e;
        public Node next;

        public Node(E e, Node next) { this.e = e; this.next = next; }

        public Node(E e) { this.e = e; this.next = null; }

        public Node() { this.e = null; this.next = null; }

        @Override
        public String toString() { return e.toString(); }
    }

    private Node head, tail;
    private int size;

    public LinkedListQueue() { head = null; tail = null; size = 0; }

    @Override
    public int getSize() { return size; }

    @Override
    public boolean isEmpty() { return size == 0; }

    @Override
    public void enqueue(E e) {
        if (tail == null) { // tail 为空时 head 也为空, 即该队列为空
            tail = new Node(e, null);
            head = tail;
        } else {
            tail.next = new Node(e, null);
            tail = tail.next;
        }
        size ++;
    }

    @Override
    public E dequeue() {
        if (isEmpty())
            throw new IllegalArgumentException("Cannot dequeue from an empty queue");
        Node delNode = head;
        head = head.next;
        delNode.next = null;
        if (head == null) // 要注意链表中只有一个元素的情况
            tail = null;
        size --;
        return delNode.e;
    }

    @Override
    public E getFront() {
        if (isEmpty())
            throw new IllegalArgumentException("Queue is Empty");
        return head.e;
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append("Queue: front ");

        Node cur = head;
        while(cur != null) {
            res.append(cur + "->");
            cur = cur.next;
        }
        res.append("NULL tail");
        return res.toString();
    }

    public static void main(String[] args){

        LinkedListQueue<Integer> queue = new LinkedListQueue<>();
        for(int i = 0 ; i < 10 ; i ++){
            queue.enqueue(i);
            System.out.println(queue);

            if(i % 3 == 2){
                queue.dequeue();
                System.out.println(queue);
            }
        }
    }
}
