package nowcoder.swordoffer.p2;

/**
 * @author dengyouquan
 * @createTime 2019-01-26
 **/
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        if (this == null) return "tree is null!";
        StringBuilder sb = new StringBuilder();
        inOrder(this, sb);
        return sb.toString();
    }

    private void inOrder(TreeNode root, StringBuilder sb) {
        if (root.left != null) {
            inOrder(root.left, sb);
        }
        if (sb.length() != 0) {
            sb.append(" ");
        }
        sb.append(root.val);
        if (root.right != null) {
            inOrder(root.right, sb);
        }
    }

    /*
        5
      / \
     3   6
    / \
   2   4
  /
 1
     */
    static TreeNode init() {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.left.left.left = new TreeNode(1);
        return root;
    }
}
