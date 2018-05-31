public class LoopQueue<E> implements Queue<E> {
    private E[] data;
    private int front, tail;
    private int size;

    public LoopQueue(int capcity) {
        data = (E[])new Object[capcity+1];
        front = 0;
        tail = 0;
        size = 0;
    }

    public LoopQueue() { this(10); }

    public int getCapcity() { return data.length - 1; }

    @Override
    public boolean isEmpty() { return front == tail; }

    @Override
    public int getSize() { return size; }

    @Override
    public E getFront() { return data[front]; }

    @Override
    public void enqueue(E e) {
        if ((tail + 1) % data.length == front)
            resize(getCapcity() * 2);

        data[tail] = e;
        tail = (tail + 1) % data.length;
        size ++;
    }

    @Override
    public E dequeue() {
        if (isEmpty())
            throw new IllegalArgumentException("Cannot deque from an empty queue.");
        E e = data[front];
        front = (front + 1) % data.length;
        size --;
        if (size == getCapcity() / 4 && getCapcity() / 2 != 0)
            resize(getCapcity() / 2);
        return e;
    }

    private void resize(int newCapcity) {
        E[] newData = (E[])new Object[newCapcity + 1];
        for (int i = 0; i < size; i ++)
            newData[i] = data[(i + front) % data.length];
        data = newData;
        front = 0;
        tail = size;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Queue size=%d, capcity=%d\nfront [", size, getCapcity()));
        for (int i = front; i != tail; i = (i + 1) % data.length) {
            res.append(data[i]);
            if ((i + 1) % data.length != tail)
                res.append(", ");
        }
        res.append("] tail");
        return res.toString();
    }

    public static void main(String[] args) {
        LoopQueue<Integer> loopqueue = new LoopQueue<>();
        for (int i = 0; i < 20; i ++) {
            loopqueue.enqueue(i);
            System.out.println(loopqueue);

            if (i % 3 == 2) {
                loopqueue.dequeue();
                System.out.println(loopqueue);
            }
        }
    }
}
