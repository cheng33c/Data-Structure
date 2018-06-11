public class MaxHeap<E extends Comparable<E>> {
    private Array<E> data;

    public MaxHeap(int capcity) { data = new Array<>(capcity); }
    public MaxHeap() { data = new Array<>(); }
    public MaxHeap(E[] arr) {
        data = new Array<>(arr);
        for (int i = parent(arr.length - 1); i >= 0; i --)
            siftDown(i);
    }

    public int size() { return data.getSize(); }
    public boolean isEmpty() { return data.isEmpty(); }

    // 返回完全二叉树表示中，一个索引的父亲节点的索引
    private int parent(int index) {
        if (index == 0)
            throw new IllegalArgumentException("index-0 doesn't have parent.");
        return (index - 1) / 2;
    }
    private int leftChild(int index) { return index * 2 + 1; }
    private int rightChild(int index) { return index * 2 + 2; }

    public void add(E e) {
        data.addLast(e);
        siftUp(data.getSize() - 1);
    }

    // 元素上移操作，用在 add 方法中，特别大的元素添加进来后调整到合适的位置
    private void siftUp(int index) {
        while (index > 0 && data.get(index).compareTo(data.get(parent(index))) > 0) {
            data.swap(index, parent(index));
            index = parent(index);
        }
    }

    public E findMax() {
        if (size() == 0)
            throw new IllegalArgumentException("MaxHeap failed; Heap is empty");
        return data.get(0);
    }

    public E extractMax() {
        E ret = findMax();
        data.swap(0, size()-1);
        data.removeLast();
        siftDown(0);
        return ret;
    }

    // 元素下移操作，用于 extractMax 方法中，当 最大的元素(root) 被取出时， 最后一个元素代替(root)然后下移调整到合适的位置
    private void siftDown(int index) {
        while (leftChild(index) < size()) { // 判断是否有左孩子，如果有左孩子，再进行循环
            int j = leftChild(index);
            if (j + 1 < size() && data.get(j + 1).compareTo(data.get(j)) > 0)
                j = rightChild(index);
            // data[j] 是 leftChild 和 rightChild的最大值
            if (data.get(index).compareTo(data.get(j)) >= 0)
                break;
            data.swap(index, j);
            index = j;
        }
    }

    public E replace(E e) {
        E ret = findMax();
        data.set(0, e);
        siftDown(0);
        return ret;
    }
}
