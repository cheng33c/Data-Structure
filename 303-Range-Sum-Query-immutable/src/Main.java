public class Main {

    public static void main(String[] args) {

        int[] nums = {-2,0,3,-5,2,-1};
        NumArray3 na = new NumArray3(nums);
        System.out.println(na.sumRange(0, 2));
        System.out.println(na.sumRange(2, 5));
        System.out.println(na.sumRange(0, 5));

    }
}
