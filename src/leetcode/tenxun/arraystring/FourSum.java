package leetcode.tenxun.arraystring;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author dengyouquan
 **/
public class FourSum {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 0, -1, 0, -2, 2};
        System.out.println(new FourSum().fourSum(nums, 0));
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        int len;
        List<List<Integer>> lists = new ArrayList<>();
        if (nums == null || (len = nums.length) < 4) return lists;
        Arrays.sort(nums);
        for (int i = 0; i < len - 3; i++) {
            for (int j = i + 1; j < len - 2; j++) {
                int t = target - nums[i] - nums[j];
                int left = j + 1;
                int right = len - 1;
                while (left < right) {
                    if (nums[left] + nums[right] == t) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[left]);
                        list.add(nums[right]);
                        lists.add(list);
                        left++;
                        right--;
                        //去 left 重复
                        while (left < right && nums[left] == nums[left - 1]) left++;
                        //去 right 重复
                        while (left < right && nums[right] == nums[right + 1]) right--;
                    } else if (nums[left] + nums[right] < t) {
                        left++;
                    } else {
                        right--;
                    }
                }
                //去 j 重复
                while (j < len - 2 && nums[j] == nums[j + 1]) j++;
            }
            //去 i 重复
            while (i < len - 3 && nums[i] == nums[i + 1]) i++;
        }
        return lists;
    }
}
