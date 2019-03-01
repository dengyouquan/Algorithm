package leetcode.tenxun.sortsearch;

/**
 * @author dengyouquan
 * @createTime 2019-01-26
 **/
public class kthSmallest {
    private int count = 0;

    public static void main(String[] args) {
        TreeNode root = TreeNode.init();
        System.out.println(new kthSmallest().kthSmallest(root, 3));
    }

    public int kthSmallest(TreeNode root, int k) {
        if (root == null) return 0;
        int result = 0;
        if (root.left != null) {
            result = kthSmallest(root.left, k);
            if (result != 0) return result;
        }
        count++;
        if (count == k) return root.val;
        if (root.right != null) {
            result = kthSmallest(root.right, k);
            if (result != 0) return result;
        }
        return 0;
    }
}
