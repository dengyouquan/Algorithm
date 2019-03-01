package nowcoder.swordoffer.p4;

import java.util.*;

/**
 * @author dengyouquan
 * @createTime 2019-02-08
 **/
public class Q59 {
    public static void main(String[] args) {
        TreeNode root = TreeNode.init();
        System.out.println(new Q59().Print(root));
    }

    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        if (pRoot == null) return lists;
        LinkedList<TreeNode> queue = new LinkedList<>();
        boolean leftToRight = true;
        queue.addLast(null);//层分隔符
        queue.addLast(pRoot);
        while (queue.size() != 1) {
            TreeNode node = queue.removeFirst();
            if (node == null) {
                ArrayList<Integer> list = new ArrayList<>();
                Iterator<TreeNode> iterator = null;
                if (leftToRight) {
                    iterator = queue.iterator();
                } else {
                    iterator = queue.descendingIterator();
                }
                leftToRight = !leftToRight;
                while (iterator.hasNext()) {
                    list.add(iterator.next().val);
                }
                lists.add(list);
                queue.addLast(null);
                continue;//一定要continue
            }
            if (node.left != null) {
                queue.addLast(node.left);
            }
            if (node.right != null) {
                queue.addLast(node.right);
            }
        }
        return lists;
    }
}
