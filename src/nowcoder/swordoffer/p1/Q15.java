package nowcoder.swordoffer.p1;

/**
 * @author dengyouquan
 * @createTime 2019-02-06
 **/
public class Q15 {
    public static void main(String[] args) {
        ListNode head = ListNode.init();
        System.out.println(new Q15().ReverseList(head));
    }

    public ListNode ReverseList(ListNode head) {
        ListNode prev = null;
        ListNode next = null;
        while (head != null) {
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}
