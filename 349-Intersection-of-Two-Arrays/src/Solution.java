import java.util.ArrayList;
import java.util.TreeSet;

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        TreeSet<Integer> set = new TreeSet<>();

        for (int num : nums1)
            set.add(num);

        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int num : nums2) {
            if (set.contains(num)) {
                arrayList.add(num);
                set.remove(num);
            }
        }
        int[] res = new int[arrayList.size()];
        for (int i = 0; i < arrayList.size(); i ++)
            res[i] = arrayList.get(i);
        return res;
    }

    public static void main(String[] args) {
        //int[] num1= {1, 2, 2, 1}, num2 = {2, 2};
        int[] num1 = {1}, num2 = {1};
        int[] res = (new Solution()).intersection(num1, num2);
        for (int r : res)
            System.out.println(r + "  ");
    }
}