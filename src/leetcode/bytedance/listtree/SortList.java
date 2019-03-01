package leetcode.bytedance.listtree;

/**
 * @author dengyouquan
 **/
public class SortList {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        ListNode head = new SortList().sortList(l1);
        System.out.println(head);
    }

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode mid = getMid(head);
        ListNode right = mid.next;
        //记得置空，将链表分成两个
        mid.next = null;
        return mergeList(sortList(head), sortList(right));
    }

    private ListNode mergeList(ListNode node1, ListNode node2) {
        if (node1 == null) return node2;
        if (node2 == null) return node1;
        ListNode l1 = node1;
        ListNode l2 = node2;
        ListNode head = null;
        if (l1.val < l2.val) {
            head = node1;
            l1 = l1.next;
        } else {
            head = node2;
            l2 = l2.next;
        }
        ListNode p = head;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                p.next = l1;
                l1 = l1.next;
                p = p.next;
            } else {
                p.next = l2;
                l2 = l2.next;
                p = p.next;
            }
        }
        if (l1 != null) {
            p.next = l1;
        }
        if (l2 != null) {
            p.next = l2;
        }
        return head;
    }

    /**
     * 快慢指针取中点
     *
     * @param head
     * @return
     */
    private ListNode getMid(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode slow = head;
        ListNode quick = head;
        while (quick.next != null && quick.next.next != null) {
            slow = slow.next;
            quick = quick.next.next;
        }
        return slow;
    }
}
