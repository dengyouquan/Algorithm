package nowcoder.swordoffer.p2;

/**
 * @author dengyouquan
 * @createTime 2019-02-06
 **/
public class Q26 {
    TreeNode head = null;
    TreeNode realHead = null;

    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) return null;
        inOrder(pRootOfTree);
        return realHead;
    }

    private void inOrder(TreeNode node) {
        if (node == null) return;
        inOrder(node.left);
        if (head == null) {
            realHead = head = node;
        } else {
            //right --> next;left --> prev;
            head.right = node;
            node.left = head;
            head = node;
        }
        inOrder(node.right);
    }

}
