package leetcode.tenxun.dp;

/**
 * @author dengyouquan
 * @createTime 2019-01-26
 **/
public class MaxSubArray {
    public static void main(String[] args) {
        int[] nums = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(new MaxSubArray().maxSubArray(nums));
    }

    public int maxSubArray(int[] nums) {
        int len;
        if (nums == null || (len = nums.length) == 0) return 0;
        int max = Integer.MIN_VALUE;
        int cur = 0;
        for (int i = 0; i < len; i++) {
            cur += nums[i];
            max = Math.max(cur, max);
            if (cur < 0) cur = 0;
        }
        return max;
    }
}
