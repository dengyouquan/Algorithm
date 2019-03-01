package leetcode.tenxun.sortsearch;

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
}
