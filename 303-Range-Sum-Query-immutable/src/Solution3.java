class NumArray3 {

    private int[] data;

    public NumArray3(int[] nums) {
        data = new int[nums.length];
        for (int i = 0; i < nums.length; i ++)
            data[i] = nums[i];
    }

    public int sumRange(int i, int j) {
        int sum = 0;
        for (int m = i; m <= j; m ++)
            sum += data[m];
        return sum;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */