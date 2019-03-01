package leetcode.tenxun.sortsearch;

/**
 * @author dengyouquan
 * @createTime 2019-01-26
 **/
public class MaxPathSum {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println(new MaxPathSum().maxPathSum(root));
    }

    private int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        getMaxPathSum(root);
        return max;
    }

    private int getMaxPathSum(TreeNode root) {
        if (root == null) return 0;
        int left = getMaxPathSum(root.left);
        int right = getMaxPathSum(root.right);
        int curSum = Math.max(Math.max(left + root.val, right + root.val), root.val);
        int curMax = Math.max(curSum, left + right + root.val);
        max = Math.max(curMax, max);
        return curSum;
    }
}
