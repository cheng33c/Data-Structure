public class Main {

    public static void main(String[] args) {
	// write your code here
        DoubleLinkedList<Integer> doubleLinkedList = new DoubleLinkedList<>();
        for (int i = 0; i < 40; i ++)
            doubleLinkedList.addFirst(i);
        System.out.println(doubleLinkedList);
        doubleLinkedList.removeLast();
        System.out.println(doubleLinkedList);
        System.out.println(doubleLinkedList.contains(5));
        System.out.println(doubleLinkedList.contains(-500));
        doubleLinkedList.removeFirst();
        System.out.println(doubleLinkedList);
        doubleLinkedList.remove(20);
        System.out.println(doubleLinkedList);
        doubleLinkedList.add(300, 3);
        System.out.println(doubleLinkedList);
        System.out.println(doubleLinkedList.get(7));
        System.out.println(doubleLinkedList.getFirst());
        System.out.println(doubleLinkedList.getLast());
    }
}
