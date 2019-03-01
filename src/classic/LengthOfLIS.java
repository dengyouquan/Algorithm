package classic;

/**
 * @author dengyouquan
 **/
public class LengthOfLIS {
    public int lengthOfLIS(int[] nums) {
       /* int len;
        if (nums == null || (len = nums.length) == 0) return 0;
        int max = 1;
        int[] dp = new int[len];
        for (int i = 0; i < len; i++) {
            int dpMax = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dpMax = Math.max(dpMax, dp[j] + 1);
                }
            }
            dp[i] = dpMax;
            max = Math.max(max, dpMax);
        }
        return max;*/
        return 0;
    }
}
