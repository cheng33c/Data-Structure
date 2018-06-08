public class Main {

    public static void main(String[] args) {
	// write your code here
        LinkedListRecursion<Integer> linkedListRecursion = new LinkedListRecursion<>();
        for (int i = 0; i < 30; i ++)
            linkedListRecursion.addFirst(i);
        System.out.println(linkedListRecursion);
        linkedListRecursion.removeFirst();
        System.out.println(linkedListRecursion);
        linkedListRecursion.removeLast();
        System.out.println(linkedListRecursion);
        linkedListRecursion.remove(20);
        System.out.println(linkedListRecursion);
        linkedListRecursion.add(10002, 2);
        System.out.println(linkedListRecursion);
        System.out.println(linkedListRecursion.contains(20));
        System.out.println(linkedListRecursion.contains(-200));
        System.out.println(linkedListRecursion.get(26));
        System.out.println(linkedListRecursion.isEmpty());
        System.out.println(linkedListRecursion.getSize());
        linkedListRecursion.addLast(10000);
        System.out.println(linkedListRecursion);
        linkedListRecursion.addFirst(-200);
        System.out.println(linkedListRecursion);

        LinkedListRecursion<Character> linkedListRecursion1 = new LinkedListRecursion<>();
        linkedListRecursion1.addFirst('a');
        linkedListRecursion1.addLast('b');
        System.out.println(linkedListRecursion1);
    }
}
