public class SegmentTree<E> {

    private E[] tree;
    private E[] data;
    private Merger<E> merger;

    public SegmentTree(E[] arr, Merger<E> merger1) {
        merger = merger1;
        data = (E[])new Object[arr.length];
        for (int i = 0; i < arr.length; i ++)
            data[i] = arr[i];

        tree = (E[])new Object[arr.length * 4];
        buildSegmentTree(0, 0, data.length - 1);
    }

    // 构造线段树, l 是最左的位置, r 是最右的位置, r - l 是线段树的区间
    private void buildSegmentTree(int treeIndex, int l, int r) {

        if (l == r) {
            tree[treeIndex] = data[l];
            return;
        }
        int leftIndex = leftChild(treeIndex), rightIndex = rightChild(treeIndex);

        int mid = l + (r - l) / 2; // 使用l + (r - l) 而不使用 (r + l) / 2的原因是防止整数溢出
        buildSegmentTree(leftIndex, l, mid);
        buildSegmentTree(rightIndex, mid + 1, r);

        tree[treeIndex] = merger.merge(tree[leftIndex], tree[rightIndex]);
    }

    // 查询[queryL, queryR]区间的值
    public E query(int queryL, int queryR) {
        if (queryL < 0 || queryL > tree.length || queryR < 0 || queryR > tree.length || queryL > queryR)
            throw new IllegalArgumentException("query failed; query index is illegal");
        return query(0, 0, data.length - 1, queryL, queryR);
    }
    // 在树区间 [l, r] 查询 [queryL, queryR]的值
    private E query(int treeIndex, int l, int r, int queryL, int queryR) {
        if (l == queryL && r == queryR)
            return tree[treeIndex];

        int mid = l + (r - l) / 2;
        int leftIndex = leftChild(treeIndex);
        int rightIndex = rightChild(treeIndex);

        if (queryL >= mid + 1) // 区间完全在右子树中
            return query(rightIndex, mid + 1, r, queryL, queryR);
        else if (queryR <= mid) // 区间完全在左子树中
            return query(leftIndex, l, mid, queryL, mid);

        // else 区间有部分在左子树有部分在右子树
        E leftResult = query(leftIndex, l, mid, queryL, mid);
        E rightResult = query(rightIndex, mid + 1, r, mid + 1, queryR);
        return merger.merge(leftResult, rightResult);
    }

    public E get(int index) {
        if (index < 0 || index >= data.length)
            throw new IllegalArgumentException("get failed; index out of bound;");
        return data[index];
    }

    public int getSize() { return data.length; }

    private int leftChild(int index) { return 2 * index + 1; }
    private int rightChild(int index) { return 2 * index + 2; }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append('[');
        for (int i = 0; i < tree.length; i ++) {
            if (tree[i] != null)
                res.append(tree[i]);
            else
                res.append("null");
            if (i != tree.length - 1)
                res.append(", ");
        }
        res.append(']');
        return res.toString();
    }
}
