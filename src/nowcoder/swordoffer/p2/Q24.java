package nowcoder.swordoffer.p2;

import java.util.ArrayList;

/**
 * @author dengyouquan
 * @createTime 2019-02-06
 **/
public class Q24 {
    public static void main(String[] args) {

    }

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        if (root == null) return lists;
        ArrayList<Integer> list = new ArrayList<>();
        FindPath(root, target, lists, list);
        return lists;
    }

    public void FindPath(TreeNode root, int target, ArrayList<ArrayList<Integer>> lists, ArrayList<Integer> list) {
        if (root == null) return;
        target -= root.val;
        if (root.left == null && root.right == null) {
            if (target == 0) {
                list.add(root.val);
                lists.add(new ArrayList<>(list));
                list.remove(list.size() - 1);
            }
        } else {
            list.add(root.val);
            FindPath(root.left, target, lists, list);
            FindPath(root.right, target, lists, list);
            list.remove(list.size() - 1);
        }
    }
}
