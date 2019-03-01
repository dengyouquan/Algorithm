package leetcode.bytedance.listtree;

import sort.HeapSort;

/**
 * @author dengyouquan
 **/
public class AddTwoNumbers {
    public static void main(String[] args) {
        /*ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(7);*/
        ListNode l1 = new ListNode(5);
        ListNode l2 = new ListNode(5);

        ListNode head = new AddTwoNumbers().addTwoNumbers(l1, l2);
        System.out.println(head);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode node = null, head = null;
        boolean carry = false;
        int sum = 0;
        while (l1 != null || l2 != null) {
            int val1 = 0;
            int val2 = 0;
            if (l1 != null) {
                val1 = l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                val2 = l2.val;
                l2 = l2.next;
            }
            sum = val1 + val2 + (carry ? 1 : 0);
            carry = false;
            if (sum >= 10) {
                sum -= 10;
                carry = true;
            }
            if (node == null) {
                head = node = new ListNode(sum);
            } else {
                node.next = new ListNode(sum);
                node = node.next;
            }
        }
        if (carry) {
            node.next = new ListNode(1);
        }
        return head;
    }
}
