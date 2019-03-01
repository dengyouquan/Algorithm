package leetcode.bytedance.listtree;

/**
 * @author dengyouquan
 **/
public class DetectCycle {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = listNode;
        System.out.println(new DetectCycle().detectCycle(listNode));
    }
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return null;
        boolean haveCycle = false;
        ListNode slow = head, quick = head;
        while (quick.next != null && quick.next.next != null) {
            slow = slow.next;
            quick = quick.next.next;
            if (slow == quick) {
                haveCycle = true;
                break;
            }
        }
        if (!haveCycle) return null;
        int cycleLen = 1;
        while ((quick = quick.next) != slow) {
            cycleLen++;
        }
        quick = head;
        slow = head;
        while (cycleLen-- > 0) {
            quick = quick.next;
        }
        while (quick != slow) {
            quick = quick.next;
            slow = slow.next;
        }
        return quick;
    }
}
