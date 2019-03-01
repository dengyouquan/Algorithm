package nowcoder.swordoffer.p2;

/**
 * @author dengyouquan
 * @createTime 2019-02-06
 **/

public class Q25 {
    //有点问题
    public static void main(String[] args) {
        RandomListNode root = new RandomListNode(1);
        root.next = new RandomListNode(2);
        root.next.random = root;
        root.next.next = new RandomListNode(3);
        root.next.next.random = root.next;
        RandomListNode newRoot = new Q25().Clone(root);
        System.out.println(newRoot);
    }

    /*
       1、复制每个节点，如：复制节点A得到A1，将A1插入节点A后面
       2、遍历链表，A1->random = A->random->next;
       3、将链表拆分成原链表和复制后的链表
   */
    public RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null) return pHead;
        RandomListNode newHead = pHead;
        while (newHead != null) {
            RandomListNode node = new RandomListNode(newHead.label);
            node.next = newHead.next;
            newHead.next = node;
            newHead = node.next;
        }
        newHead = pHead;
        while (newHead != null) {
            RandomListNode node = newHead.next;
            if (newHead.random != null) {
                node.random = newHead.random.next;
            }
            newHead = node.next;
        }
        newHead = pHead.next;
        RandomListNode cloneHead = newHead;
        while (newHead.next != null) {
            RandomListNode temp = newHead.next;
            newHead.next = temp.next;
            newHead = temp;
        }
        return cloneHead;
    }
}
