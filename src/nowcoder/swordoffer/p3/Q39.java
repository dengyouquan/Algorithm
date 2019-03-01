package nowcoder.swordoffer.p3;

/**
 * @author dengyouquan
 * @createTime 2019-02-07
 **/
public class Q39 {
    public static void main(String[] args) {
        TreeNode root = TreeNode.init();
        System.out.println(new Q39().IsBalanced_Solution(root));
    }

    public boolean IsBalanced_Solution(TreeNode root) {
        if (root == null) return true;
        return isBalanced(root);
    }

    private boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        return Math.abs(getDepth(root.left) - getDepth(root.right)) < 2 && isBalanced(root.left) && isBalanced(root.right);
    }

    private int getDepth(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(getDepth(root.left), getDepth(root.right));
    }
}
