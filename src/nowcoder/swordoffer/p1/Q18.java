package nowcoder.swordoffer.p1;

/**
 * @author dengyouquan
 * @createTime 2019-02-06
 **/
public class Q18 {
    public static void main(String[] args) {
        TreeNode root = TreeNode.init();
        System.out.println(root);
        new Q18().Mirror(root);
        System.out.println(root);
    }

    public void Mirror(TreeNode root) {
        if (root == null) return;
        TreeNode temp = root.right;
        root.right = root.left;
        root.left = temp;
        if (root.left != null) {
            Mirror(root.left);
        }
        if (root.right != null) {
            Mirror(root.right);
        }
    }
}
