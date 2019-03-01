package nowcoder.swordoffer.p3;

/**
 * @author dengyouquan
 * @createTime 2019-02-07
 **/
public class Q38 {
    public static void main(String[] args) {
        TreeNode root = TreeNode.init();
        System.out.println(new Q38().TreeDepth(root));
    }

    public int TreeDepth(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(TreeDepth(root.left), TreeDepth(root.right));
    }
}
