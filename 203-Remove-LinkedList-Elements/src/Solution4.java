public class Solution4 {
    // 使用递归方法解决
    public ListNode removeElements(ListNode head, int val) {
        if (head == null)
            return null;
        ListNode res = removeElements(head.next, val);
        if (head.val == val)
            return res;
        else {
            head.next = res;
            return head;
        }
    }

    // 使用递归方法解决
    public ListNode removeElements_method2(ListNode head, int val) {
        if (head == null)
            return null;
        head.next = removeElements(head.next, val);
        return head.val == val ? head.next : head;
    }

}
