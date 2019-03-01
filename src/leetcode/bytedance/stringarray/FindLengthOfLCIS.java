package leetcode.bytedance.stringarray;

/**
 * @author dengyouquan
 **/
public class FindLengthOfLCIS {
    public static void main(String[] args) {
        System.out.println(new FindLengthOfLCIS().findLengthOfLCIS(new int[]{1, 3, 5, 7}));
    }

    public int findLengthOfLCIS(int[] nums) {
        int len;
        if (nums == null || (len = nums.length) == 0) return 0;
        int max = 0, num = 1;
        for (int i = 1; i < len; i++) {
            if (nums[i] > nums[i - 1]) {
                num++;
            } else {
                max = Math.max(max, num);
                num = 1;
            }
        }
        max = Math.max(max, num);
        return max;
    }
}
