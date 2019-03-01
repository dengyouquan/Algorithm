package leetcode.tenxun.sortsearch;

/**
 * @author dengyouquan
 * @createTime 2019-01-26
 **/
public class LowestCommonAncestor1 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root.val == p.val || root.val == q.val) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        ////如果p,q刚好在左右两个子树上
        if (left != null && right != null) {
            return root;
        }
        ////仅在右子树
        if (left == null) return right;
        ////仅在左子树
        if (right == null) return left;
        return null;
    }
}
