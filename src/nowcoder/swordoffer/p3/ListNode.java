package nowcoder.swordoffer.p3;

/**
 * @author dengyouquan
 * @createTime 2019-01-25
 **/
public class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        ListNode next = this.next;
        StringBuilder sb = new StringBuilder();
        sb.append(val);
        while (next != null) {
            sb.append("->");
            sb.append(next.val);
            next = next.next;
        }
        return sb.toString();
    }

    static ListNode init() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        return head;
    }

    static ListNode init(int[] nums) {
        int len;
        if (nums == null || (len = nums.length) == 0) return null;
        ListNode head = new ListNode(nums[0]);
        ListNode p = head;
        for (int i = 1; i < len; i++) {
            p.next = new ListNode(nums[i]);
            p = p.next;
        }
        return head;
    }
}
