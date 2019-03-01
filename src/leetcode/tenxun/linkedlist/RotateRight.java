package leetcode.tenxun.linkedlist;

/**
 * @author dengyouquan
 * @createTime 2019-01-25
 **/
public class RotateRight {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        System.out.println(new RotateRight().rotateRight(head, 1080000007));
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0) return head;
        int len = 0, index = 0;
        ListNode fast = head, slow = head;
        while (fast != null) {
            fast = fast.next;
            index++;
            len++;
            if (index == k) break;
        }
        //k>len
        if (fast == null) {
            k %= len;
            //不移动
            if (k == 0) return head;
            //重新找fast
            fast = head;
            while (fast != null && k-- > 0) {
                fast = fast.next;
            }
        }
        //find 临界点
        ListNode prev = null;
        while (fast != null) {
            fast = fast.next;
            prev = slow;
            slow = slow.next;
        }
        //拼接 链表
        ListNode newHead = slow;
        while (slow.next != null) {
            slow = slow.next;
        }
        slow.next = head;
        prev.next = null;
        return newHead;
    }
}
