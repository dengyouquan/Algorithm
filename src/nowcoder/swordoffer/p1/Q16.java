package nowcoder.swordoffer.p1;

/**
 * @author dengyouquan
 * @createTime 2019-02-06
 **/
public class Q16 {
    public static void main(String[] args) {
        ListNode list1 = ListNode.init(new int[]{1, 3, 5});
        ListNode list2 = ListNode.init(new int[]{2, 4, 6});
        System.out.println(new Q16().Merge(list1, list2));
    }

    public ListNode Merge(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;
        if (list1.val < list2.val) {
            list1.next = Merge(list1.next, list2);
            return list1;
        } else {
            list2.next = Merge(list1, list2.next);
            return list2;
        }
    }

    public ListNode Merge1(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;//1 3 5
        if (list2 == null) return list1;//2 4 6
        //用一个虚拟头结点
        ListNode root = new ListNode(0);
        ListNode head = root;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                head.next = list1;
                head = head.next;
                list1 = list1.next;
            } else {
                head.next = list2;
                head = head.next;
                list2 = list2.next;
            }
        }
        if (list1 != null) {
            head.next = list1;
        }
        if (list2 != null) {
            head.next = list2;
        }
        return root.next;
    }
}
