import java.util.ArrayList;
import java.util.Random;

public class Main3 {

    public static void main(String[] args) {
        // 2千万有序数据做存储操作
        // 不测试BST，BST这种情况下退化为链表，速度太慢
        int n = 20000000;

        Random random = new Random();
        ArrayList<Integer> testdata = new ArrayList<>();
        for (int i = 0; i < n; i ++)
            testdata.add(random.nextInt(Integer.MAX_VALUE));



        // test avl Tree
        long startTime = System.nanoTime();
        AVLTree<Integer, Integer> avl = new AVLTree<>();

        for (Integer x : testdata)
            avl.add(x, null);

        long endTime = System.nanoTime();
        double time = (endTime - startTime) / 1000000000.0;
        System.out.println("AVL Tree: " + time + " s");

        // test RB Tree
        startTime = System.nanoTime();
        RBTree<Integer, Integer> rb = new RBTree<>();

        for (Integer x : testdata)
            rb.add(x, null);

        endTime = System.nanoTime();
        time = (endTime - startTime) / 1000000000.0;
        System.out.println("RB Tree: " + time + " s");
    }
}
