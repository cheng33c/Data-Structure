public class Main {

    public static void main(String[] args) {

        Array<Integer> arr = new Array();
        System.out.println(arr);
        for (int k = 0; k < 3; k ++) {
            for (int i = 0; i < 15; i++)
                arr.addLast(i);
        }
        System.out.println(arr);

//        arr.add(1, 100);
//        System.out.println(arr);
//
//        arr.addFirst(-1);
//        System.out.println(arr);

        int[] res = arr.findAll(5);
        for (int i = 0; i < res.length; i ++)
            System.out.print(res[i] + " ");

        arr.removeElement(1);
        System.out.println(arr);

        arr.remove(3);
        System.out.println(arr);

        arr.removeAllElement(10);
        System.out.println(arr);

        arr.set(2, 10000);
        System.out.println(arr);

        System.out.println(arr.contains(50));
        System.out.println(arr.contains(5));
        System.out.println(arr.get(5));
        arr.removeFirst();
        System.out.println(arr);
        arr.removeLast();
        System.out.println(arr);
    }
}
