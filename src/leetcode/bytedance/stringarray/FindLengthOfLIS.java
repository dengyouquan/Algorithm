package leetcode.bytedance.stringarray;

/**
 * @author dengyouquan
 **/
public class FindLengthOfLIS {
    public static void main(String[] args) {
        System.out.println(new FindLengthOfLIS().
                findLengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
        ;
    }

    public int findLengthOfLIS(int[] nums) {
        int len = nums.length;
        if (len == 0) return 0;
        int[] dp = new int[len];
        int max = 1;
        for (int i = 0; i < len; i++) {
            int dpMax = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dpMax = Math.max(dpMax, dp[j] + 1);
                }
            }
            dp[i] = dpMax;
            max = Math.max(dpMax, max);
        }
        return max;
    }
}
