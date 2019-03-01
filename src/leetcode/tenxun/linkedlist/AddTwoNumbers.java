package leetcode.tenxun.linkedlist;

/**
 * @author dengyouquan
 * @createTime 2019-01-25
 **/
public class AddTwoNumbers {
    public static void main(String[] args) {
        /*ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);*/
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(9);
        l2.next = new ListNode(9);
        System.out.println(new AddTwoNumbers().addTwoNumbers(l1, l2));
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode head = null, node = null;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int a = 0;
            int b = 0;
            if (l1 != null) {
                a = l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                b = l2.val;
                l2 = l2.next;
            }
            int c = (a + b + carry);
            if (c >= 10) {
                c -= 10;
                carry = 1;
            } else {
                carry = 0;
            }
            if (head == null) {
                node = head = new ListNode(c);
            } else {
                node.next = new ListNode(c);
                node = node.next;
            }
        }
        if (carry != 0) {
            node.next = new ListNode(carry);
        }
        return head;
    }
}
