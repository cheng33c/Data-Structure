import java.util.ArrayList;
import java.util.TreeMap;

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int num : nums1) {
            if (!map.containsKey(num)) map.put(num, 1);
            else map.put(num, map.get(num) + 1);
        }

        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int num : nums2) {
            if (map.containsKey(num)) {
                arrayList.add(num);
                map.put(num, map.get(num) - 1);
                if (map.get(num) == 0)
                    map.remove(num);
            }
        }

        int[] ret = new int[arrayList.size()];
        for (int i = 0; i < ret.length; i ++)
            ret[i] = arrayList.get(i);
        return ret;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 1}, nums2 = {2, 2};
        int[] ret = (new Solution()).intersect(nums1, nums2);
        for (int i = 0; i < ret.length; i ++)
            System.out.print(ret[i] + "   ");
    }
}