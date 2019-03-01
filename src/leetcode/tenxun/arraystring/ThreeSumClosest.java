package leetcode.tenxun.arraystring;

import java.util.Arrays;

/**
 * @author dengyouquan
 **/
public class ThreeSumClosest {
    public static void main(String[] args) {
        int[] nums = new int[]{-1, 2, 1, -4};
        System.out.println(new ThreeSumClosest().threeSumClosest(nums, 1));
    }

    public int threeSumClosest(int[] nums, int target) {
        int len;
        if (nums == null || (len = nums.length) < 3) return 0;
        int sum = 0, min = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for (int i = 0; i < len - 2; i++) {
            int j = i + 1;
            int k = len - 1;
            int t = target - nums[i];
            while (j < k) {
                int diff = nums[j] + nums[k] - t;
                int abs = Math.abs(diff);
                if (diff == 0) {
                    return target;
                } else {
                    if (min > abs) {
                        min = abs;
                        sum = nums[i] + nums[j] + nums[k];
                    }
                    if (diff < 0) j++;
                    else k--;
                }
            }
        }
        return sum;
    }
}
