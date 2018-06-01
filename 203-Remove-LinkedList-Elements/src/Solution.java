import java.lang.reflect.Array;
import java.util.List;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {

    public ListNode removeElements_method2(ListNode head, int val) {
        // 老师的答案, 不使用虚拟头结点
        while (head != null && head.val == val) {
            ListNode delNode = head;
            head = head.next;
            delNode.next = null;
        }

        if (head == null)
            return null;

        ListNode prev = head;
        while (prev.next != null) {
            if (prev.next.val == val) {
                ListNode delNode = prev.next;
                prev.next = delNode.next;
                delNode.next = null;
            } else {
                prev = prev.next;
            }
        }
        return head;
    }

    public ListNode removeElements(ListNode head, int val) {
        if (head == null)
            return null;

        ListNode cur = head;
        while (head.val == val) {
            if (head.next == null) {
                return null;
            } else {
                cur = head.next;
                head.next = null;
                head = cur;
            }
        }
        while (cur != null) {
            if (cur.next != null && cur.next.val == val) {
                ListNode delNode = cur.next;
                cur.next = delNode.next;
                delNode.next = null;
            }
            else
                cur = cur.next;
        }
        return head;
    }

    public static void main(String[] args) {
        //int[] arr = new int[]{1, 2, 6, 3, 4, 5, 6}; // test case 1
        //int[] arr = new int[]{1}; // test case 2
        int[] arr = new int[]{1, 2, 2, 1};


//        ListNode head = new ListNode(arr[0]);
//        ListNode cur = head;
//        for (int i = 1; i < arr.length; i ++) {
//            cur.next = new ListNode(arr[i]);
//            cur = cur.next;
//        }
        ListNode head = new ListNode(arr);
        System.out.println(head);
        head = (new Solution()).removeElements_method2(head, 2);
        System.out.println(head);
    }
}