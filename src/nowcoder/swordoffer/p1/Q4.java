package nowcoder.swordoffer.p1;

import java.util.HashMap;
import java.util.Map;

/**
 * @author dengyouquan
 * @createTime 2019-02-05
 **/
public class Q4 {
    public static void main(String[] args) {
        int[] pre = new int[]{1, 2, 4, 7, 3, 5, 6, 8};
        int[] in = new int[]{4, 7, 2, 1, 5, 3, 8, 6};
        TreeNode root = new Q4().reConstructBinaryTree(pre, in);
        System.out.println(root);
    }

    Map<Integer, Integer> map = new HashMap<>();

    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        if (pre == null || in == null) return null;
        initMap(in);
        return reConstructBinaryTree(pre, 0, pre.length - 1, in, 0, in.length - 1);
    }

    public TreeNode reConstructBinaryTree(int[] pre, int preStart, int preEnd, int[] in, int inStart, int inEnd) {
        if (preStart > preEnd) return null;
        TreeNode node = new TreeNode(pre[preStart]);
        int index = map.get(pre[preStart]);
        node.left = reConstructBinaryTree(pre, preStart + 1, preStart + (index - inStart), in, inStart, index - 1);
        node.right = reConstructBinaryTree(pre, preStart + 1 + (index - inStart), preEnd, in, index + 1, inEnd);
        return node;
    }

    //用map，固定，不用每次遍历数组
    private void initMap(int[] in) {
        for (int i = 0; i < in.length; i++) {
            map.put(in[i], i);
        }
    }
}
