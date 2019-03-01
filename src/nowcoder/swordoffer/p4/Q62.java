package nowcoder.swordoffer.p4;

/**
 * @author dengyouquan
 * @createTime 2019-02-08
 **/
public class Q62 {

    int count = 0;

    TreeNode KthNode(TreeNode pRoot, int k) {
        if (pRoot == null || k < 1) return null;
        TreeNode node = KthNode(pRoot.left, k);
        if (node != null) return node;
        count++;
        if (count == k) return pRoot;
        node = KthNode(pRoot.right, k);
        if (node != null) return node;
        return null;
    }

}
