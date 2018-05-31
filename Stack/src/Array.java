public class Array<E> {
    private E[] data;
    private int size;

    // 有参数构造函数, 传入capacity构造Array
    public Array(int capacity) {
        data = (E[])new Object[capacity];
        size = 0;
    }

    // 无参数构造函数, 默认capacity=10
    public Array() { this(10); }

    // 获取数组中元素个数
    public int getSize() { return size; }

    // 获取数组的容量
    public int getCapcity() { return data.length; }

    // 获取数组第一个元素
    public E getFirst() { return get(0); }

    // 获取数组最后一个元素
    public E getLast() { return get(size - 1); }

    // 判断数组是否为空
    public boolean isEmpty() { return size == 0; }

    // 在数组最后一个位置添加元素e
    public void addLast(E e) { add(size, e); }

    public void addFirst(E e) { add(0, e); }

    // 向数组第 index 个位置添加元素e
    public void add(int index, E e) {
        if (index < 0 || index > data.length)
            throw new IllegalArgumentException("add failed. index illegal");
        if (size == data.length)
            resize(2 * data.length);

        for (int i = size - 1; i >= index; i --)
            data[i + 1] = data[i];
        data[index] = e;
        size ++;
    }

    // 获取 index 位置元素
    public E get(int index) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("get failed. index illegal");
        return data[index];
    }

    // 查找数组中是否包含元素 e
    public boolean contains(E e) {
        for (int i = 0; i < size; i ++)
            if (data[i].equals(e))
                return true;
        return false;
    }

    // 返回数组中元素 e 的索引 index
    // 该方法只能返回其中一个 e, 如果要全部 e 都返回, 使用 findAll
    public int find(E e) {
        for (int i = 0; i < size; i ++)
            if (data[i].equals(e))
                return i;
        return -1;
    }

    public int[] findAll(E e) {
        int[] arr = new int[size];
        int count = 0;
        for (int i = 0; i < size; i ++)
            if (data[i].equals(e))
                arr[count ++] = i;
        return arr;
    }

    // 删除数组中 index 索引位置的元素 e, 并返回 e
    public E remove(int index) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("get failed. index illegal");
        E e = data[index];
//        for (int i = index + 1; i < size; i ++)
//            data[i - 1] = data[i];
        for (int i = index; i < size - 1; i ++)
            data[i] = data[i + 1];
        size --;
        data[size] = null;

        if (size == data.length / 4 && data.length / 2 != 0)
            resize(data.length / 2);
        return e;
    }

    // 删除第一个元素, 返回删除元素
    public E removeFirst() { return remove(0); }

    // 删除最后一个元素, 返回删除元素
    public E removeLast() { return remove(size - 1); }

    // 寻找数组中的元素 e ,若存在则删除元素 e 并返回true, 否则返回false
    // 该方法只能删除数组中的一个元素, 如果想删除数组中全部元素 e, 使用 removeAllElement
    // 不返回元素 e 的原因是因为删除前用户已经知道元素 e 了,所以不需要返回
    public boolean removeElement(E e) {
        int index = find(e);
        if (index != -1) {
            remove(index);
            return true;
        }
        return false;
    }

    public boolean removeAllElement(int e) {
        boolean flag = false;
        for (int i = 0; i < size; i ++) {
            if (data[i].equals(e)) {
                remove(i);
                flag = true;
            }
        }
        return flag;
    }

    // 替换 index 位置的元素为e
    public void set(int index, E e) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("get failed. index illegal");
        data[index] = e;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("size = %d, capcity = %d\n[", size, data.length));
        for (int i = 0; i < size; i ++) {
            res.append(data[i]);
            if (i < size - 1)
                res.append(", ");
        }
        res.append("]");
        return res.toString();
    }

    private void resize(int newCapcity) {
        E[] newData = (E[])new Object[newCapcity];
        for (int i = 0; i < size; i ++)
            newData[i] = data[i];
        data = newData;
    }
}
