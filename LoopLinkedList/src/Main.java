public class Main {
    public static void main(String[] args) {
        LoopLinkedList<Integer> loopLinkedList = new LoopLinkedList<>();

//        for (int i = 0; i < 20; i ++)
//            loopLinkedList.addFirst(i);
//        System.out.println(loopLinkedList);
//        loopLinkedList.remove(3);
//        System.out.println(loopLinkedList);
//        loopLinkedList.add(500, 6);
//        System.out.println(loopLinkedList);
//        loopLinkedList.removeFirst();
//        System.out.println(loopLinkedList);
//        loopLinkedList.removeLast();
//        System.out.println(loopLinkedList);
//
//        System.out.println(loopLinkedList.contains(500));
//        System.out.println(loopLinkedList.contains(10));
//        System.out.println(loopLinkedList.contains(5000));
//        System.out.println("get(10):" + loopLinkedList.get(10));
//        System.out.println(loopLinkedList.get(15));
//        System.out.println(loopLinkedList.get(3));
//        System.out.println(loopLinkedList.getFirst());
//        System.out.println(loopLinkedList.getLast());
//        loopLinkedList.set(60, 2);
//        System.out.println(loopLinkedList);
        for (int i = 0; i < 7; i ++)
            loopLinkedList.addLast(i);
        System.out.println(loopLinkedList);
        loopLinkedList.remove(4);
        System.out.println(loopLinkedList);
        loopLinkedList.remove(2);
        System.out.println(loopLinkedList);
        loopLinkedList.add(2, 2);
        loopLinkedList.add(4, 4);
        System.out.println(loopLinkedList);
        System.out.println(loopLinkedList.getFirst());
        System.out.println(loopLinkedList.getLast());
        System.out.println(loopLinkedList.get(5));
        loopLinkedList.set(50, 2);
        System.out.println(loopLinkedList);
        loopLinkedList.set(20, 5);
        System.out.println(loopLinkedList);
    }
}
