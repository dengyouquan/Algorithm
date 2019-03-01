package leetcode.tenxun.linkedlist;

/**
 * @author dengyouquan
 * @createTime 2019-01-25
 **/
public class DetectCycle {
    public static void main(String[] args) {

    }

    public ListNode detectCycle1(ListNode head) {
        if (head == null || head.next == null) return null;
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                slow = head;
                while (slow != fast) {
                    fast = fast.next;
                    slow = slow.next;
                }
                return slow;
            }
        }
        return null;
    }

    public ListNode detectCycle(ListNode head) {
        if (head == null) return head;
        ListNode fast = head;
        ListNode slow = head;
        boolean hasCycle = false;
        //judge has cycle
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                hasCycle = true;
                break;
            }
        }
        if (!hasCycle) return null;
        //get cycle length
        int cycleLen = 1;
        fast = fast.next;
        while (fast != slow) {
            cycleLen++;
            fast = fast.next;
        }
        //get cycle entry
        fast = head;
        slow = head;
        while (cycleLen-- > 0) {
            fast = fast.next;
        }
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }
}
