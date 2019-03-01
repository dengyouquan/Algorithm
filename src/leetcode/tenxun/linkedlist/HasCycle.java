package leetcode.tenxun.linkedlist;

/**
 * @author dengyouquan
 * @createTime 2019-01-25
 **/
public class HasCycle {
    public boolean hasCycle(ListNode head) {
        if (head == null) return false;
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) return true;
        }
        return false;
    }
}
