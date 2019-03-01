package leetcode.tenxun.linkedlist;

/**
 * @author dengyouquan
 * @createTime 2019-01-25
 **/
public class DeleteNode {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
