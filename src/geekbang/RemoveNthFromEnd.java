package geekbang;

/**
 * @author dengyouquan
 **/
public class RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //构造假结点，避免特殊情况
        ListNode root = new ListNode(0);
        root.next = head;
        ListNode fast = root;
        while (n-- >= 0 && fast != null) {
            fast = fast.next;
        }
        ListNode slow = root;
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return root.next;
    }
}
