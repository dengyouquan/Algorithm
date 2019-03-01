package leetcode.tenxun.number;

/**
 * @author dengyouquan
 * @createTime 2019-01-25
 **/
public class SingleNumber {
    public static void main(String[] args) {

    }

    public int singleNumber(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            nums[0] ^= nums[i];
        }
        return nums[0];
    }
}
