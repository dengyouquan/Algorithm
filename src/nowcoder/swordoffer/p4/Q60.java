package nowcoder.swordoffer.p4;

import java.util.*;

/**
 * @author dengyouquan
 * @createTime 2019-02-08
 **/
public class Q60 {
    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        if (pRoot == null) return lists;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(null);
        queue.addLast(pRoot);
        while (queue.size() != 1) {
            TreeNode node = queue.removeFirst();
            if (node == null) {
                ArrayList<Integer> list = new ArrayList<>();
                Iterator<TreeNode> iterator = queue.iterator();
                while (iterator.hasNext()) {
                    list.add(iterator.next().val);
                }
                lists.add(list);
                queue.add(null);
                continue;
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
