public class Main {

    public static void main(String[] args) {
        BSTNR<Integer> bst = new BSTNR<>();
        int[] nums = {5,3,6,8,4,2};
        for (int num : nums)
            bst.add(num);

        bst.preOrder();
        System.out.println();

//        bst.inOrder();
//        System.out.println();
//
//
//        bst.postOrder();
//        System.out.println();
//
//        bst.preOrderNR();
//        System.out.println();

        System.out.println(bst);
    }
}
