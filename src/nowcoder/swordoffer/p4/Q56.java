package nowcoder.swordoffer.p4;

/**
 * @author dengyouquan
 * @createTime 2019-02-08
 **/
public class Q56 {
    public static void main(String[] args) {
        ListNode root = new ListNode(2);
        root.next = new ListNode(2);
        root.next.next = new ListNode(2);
        root.next.next.next = new ListNode(2);
        root.next.next.next.next = new ListNode(2);
        System.out.println(new Q56().deleteDuplication(root));
    }

    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null || pHead.next == null) return pHead;
        if (pHead.val == pHead.next.val) {
            ListNode node = pHead.next;
            // 跳过值与当前结点相同的全部结点,找到第一个与当前结点不同的结点
            while (node != null && node.val == pHead.val) {
                node = node.next;
            }
            return deleteDuplication(node);
        } else {
            pHead.next = deleteDuplication(pHead.next);
            return pHead;
        }
    }
}
