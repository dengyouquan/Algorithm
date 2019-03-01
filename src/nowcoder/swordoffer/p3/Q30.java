package nowcoder.swordoffer.p3;

/**
 * @author dengyouquan
 * @createTime 2019-02-07
 **/
public class Q30 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, -2, 3, 10, -4, 7, 2, -5};
        System.out.println(new Q30().FindGreatestSumOfSubArray(nums));
    }

    //动态规划
    public int FindGreatestSumOfSubArray(int[] array) {
        int len;
        if (array == null || (len = array.length) == 0) return 0;
        //不能设为0，可能是负数
        int sum = array[0];
        int max = array[0];
        for (int i = 1; i < len; i++) {
            sum = (sum < 0) ? array[i] : sum + array[i];
            max = (sum > max) ? sum : max;
        }
        return max;
    }
}
