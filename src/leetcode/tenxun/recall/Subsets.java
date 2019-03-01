package leetcode.tenxun.recall;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dengyouquan
 * @createTime 2019-01-26
 **/
public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        int len = nums.length;
        getSubSet(nums, 0, len, list, lists);
        return lists;
    }

    private void getSubSet(int[] nums, int start, int len, List<Integer> list, List<List<Integer>> lists) {
        lists.add(new ArrayList<>(list));
        for (int i = start; i < len; i++) {
            list.add(nums[i]);
            getSubSet(nums, i + 1, len, list, lists);
            list.remove(list.size() - 1);
        }
    }
}
