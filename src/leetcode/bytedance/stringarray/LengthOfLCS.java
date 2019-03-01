package leetcode.bytedance.stringarray;

/**
 * @author dengyouquan
 **/
public class LengthOfLCS {
    public int lengthOfLCS(int[] nums1, int[] nums2) {
        int len1, len2;
        if (nums1 == null || (len1 = nums1.length) == 0
                || nums2 == null || (len2 = nums2.length) == 0) return 0;
        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (nums1[i] == nums2[j]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        return dp[len1][len2];
    }
}
