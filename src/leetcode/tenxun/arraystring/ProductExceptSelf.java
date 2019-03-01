package leetcode.tenxun.arraystring;

/**
 * @author dengyouquan
 * @createTime 2019-01-24
 **/
public class ProductExceptSelf {
    public static void main(String[] args) {

    }

    public int[] productExceptSelf(int[] nums) {
        int len;
        if (nums == null || (len = nums.length) == 0) return null;
        int[] output = new int[len];
        int left = 1, right = 1;
        for (int i = 0; i < len; i++) {
            output[i] = 1;
        }
        //每一个数除了它本身所有数的乘积都是他左边数的乘积 乘以 右边数的乘积
        for (int i = 0; i < len; i++) {
            output[i] *= left;
            output[len - 1 - i] *= right;
            left *= nums[i];
            right *= nums[len - 1 - i];
        }
        return output;
    }
}
