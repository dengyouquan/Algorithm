package leetcode.tenxun.arraystring;

import java.util.HashMap;
import java.util.Map;

/**
 * @author dengyouquan
 **/
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int len = 0;
        if (nums == null || (len = nums.length) == 0) return nums;
        Map<Integer, Integer> map = new HashMap<>();
        int[] arr = new int[2];
        for (int i = 0; i < len; i++) {
            int diff = target - nums[i];
            if (map.containsKey(diff)) {
                arr[0] = map.get(diff);
                arr[1] = i;
            } else {
                map.put(nums[i], i);
            }
        }
        return arr;
    }
}
