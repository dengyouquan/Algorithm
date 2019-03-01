package leetcode.tenxun.arraystring;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author dengyouquan
 **/
public class ThreeSum {
    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        System.out.println(new ThreeSum().threeSum(nums));
    }

    public List<List<Integer>> threeSum(int[] nums) {
        int len;
        List<List<Integer>> lists = new ArrayList<>();
        if (nums == null || (len = nums.length) < 3) return lists;
        Arrays.sort(nums);
        for (int i = 0; i < len; i++) {
            //正数跳出
            if (nums[i] > 0) break;
            //去除第一层重复数字
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int target = 0 - nums[i];
            int j = i + 1;
            int k = len - 1;
            while (j < k) {
                if (nums[j] + nums[k] == target) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    lists.add(list);
                    //去除 j,k 重复
                    while (j < k && nums[j] == nums[j + 1]) j++;
                    while (j < k && nums[k] == nums[k - 1]) k--;
                    j++;
                    k--;
                } else if (nums[j] + nums[k] < target) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        return lists;
    }
}
