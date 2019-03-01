package nowcoder.swordoffer.p1;

import java.util.ArrayList;

/**
 * @author dengyouquan
 * @createTime 2019-02-05
 **/
public class Q3 {
    ArrayList<Integer> arrayList = new ArrayList<>();

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        if (listNode != null) {
            printListFromTailToHead(listNode.next);
            arrayList.add(listNode.val);
        }
        return arrayList;
    }
}
