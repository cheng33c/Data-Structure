class NumArray2 {

    private int[] sums; // 存储nums[0, i]的和

    public NumArray2(int[] nums) {
        sums = new int[nums.length + 1];
        sums[0] = 0;

        for (int i = 1; i <= nums.length; i ++)
            sums[i] = nums[i - 1] + sums[i - 1];

    }

    public int sumRange(int i, int j) {
        return sums[j + 1] - sums[i];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */