package leetcode.tenxun.recall;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dengyouquan
 * @createTime 2019-01-26
 **/
public class Permute {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        System.out.println(new Permute().permute(nums));
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        getPermute(nums, lists, list, 0);
        return lists;
    }

    private void getPermute(int[] nums, List<List<Integer>> lists, List<Integer> list, int len) {

        if (len == nums.length) {
            lists.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!list.contains(nums[i])) {
                list.add(nums[i]);
                getPermute(nums, lists, list, len + 1);
                //回溯
                list.remove(list.size() - 1);
            }
        }
    }
}
