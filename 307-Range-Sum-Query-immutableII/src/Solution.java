class NumArray {

    private SegmentTree<Integer> segmentTree;

    public NumArray(int[] nums) {
        if (nums.length > 0) {
            Integer[] data = new Integer[nums.length];
            for (int i = 0; i < data.length; i ++)
                data[i] = nums[i];
            segmentTree = new SegmentTree<>(data, (a, b) -> a + b);
        }
    }

    public void update(int index, int val) {
        if (segmentTree == null)
            throw new IllegalArgumentException("update failed; SegmentTree is null");
        segmentTree.set(index, val);
    }

    public int sumRange(int i, int j) {
        if (segmentTree == null)
            throw new IllegalArgumentException("sumRange failed; SegmentTree is null;");
        return segmentTree.query(i, j);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */