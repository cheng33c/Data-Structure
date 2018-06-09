import java.util.ArrayList;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        // Test 1
//        BST<Integer> bst = new BST<>();
//        int[] nums = {5,3,6,8,4,1, 2};
//        for (int num : nums)
//            bst.add(num);

//        bst.levelOrder();
//        System.out.println(bst);
//
//        System.out.println(bst.removeMin());
//        System.out.println(bst);

//        bst.preOrder();
//        System.out.println();

//        bst.inOrder();
//        System.out.println();
//
//
//        bst.postOrder();
//        System.out.println();
//
//        bst.preOrderNR();
//        System.out.println();

//        System.out.println(bst);



        // Test 2 it tests removeMin
//        BST<Integer> bst = new BST<>();
//        Random random = new Random();
//        int n = 10000;
//        for (int i = 0; i < n; i ++)
//            bst.add(random.nextInt(100000));
//        ArrayList<Integer> nums = new ArrayList<>();
//        while (!bst.isEmpty())
//            nums.add(bst.removeMin());
//        System.out.println(nums);
//
//        for (int i = 1; i < nums.size(); i ++) // 这里的nums不一定是n,因为random会生成重复的元素,所以要用nums.size()
//            if (nums.get(i - 1) > nums.get(i))
//                throw new IllegalArgumentException("Error");
//        System.out.println("removeMin test completed");

        // Test 3 it tests removeMax
//        BST<Integer> bst = new BST<>();
//        Random random = new Random();
//        int n = 10000;
//        for (int i = 0; i < n; i ++)
//            bst.add(random.nextInt(100000));
//        ArrayList<Integer> nums = new ArrayList<>();
//        while (!bst.isEmpty())
//            nums.add(bst.removeMax());
//        System.out.println(nums);
//
//        for (int i = 1; i < nums.size(); i ++) // 这里的nums不一定是n,因为random会生成重复的元素,所以要用nums.size()
//            if (nums.get(i - 1) < nums.get(i))
//                throw new IllegalArgumentException("Error");
//        System.out.println("removeMin test completed");

        // Test 4 it test remove
        BST<Integer> bst = new BST<>();
        int n = 30;
        for (int i = 0; i < n; i ++)
            bst.add(i);
        System.out.println(bst);
        bst.remove(25);
        System.out.println(bst);
    }
}
