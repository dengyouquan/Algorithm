package leetcode.bytedance.stringarray;

import java.util.*;

/**
 * @author dengyouquan
 **/
public class ThreeSum {
    public static void main(String[] args) {
        int[] array = new int[]{-1, 0, 1, 2, -1, -4};
        System.out.println(new ThreeSum().threeSum(array));
    }

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int target = -nums[i];
            int start = i + 1;
            int end = nums.length - 1;
            //双指针扫描是否存在两个数等于 target
            while (start < end) {
                int sum = nums[start] + nums[end];
                if (sum == target) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[start]);
                    list.add(nums[end]);
                    lists.add(list);
                    start++;
                    end--;
                    //去 start 重复
                    while (start < end && nums[start] == nums[start - 1]) start++;
                    while (start < end && nums[end] == nums[end + 1]) end--;
                } else if (sum < target) {
                    start++;
                } else {
                    end--;
                }
            }
            // 去 i 重复
            while (i < nums.length - 2 && nums[i] == nums[i + 1]) {
                i++;
            }
        }
        return lists;
    }
}
