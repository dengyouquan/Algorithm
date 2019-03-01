package leetcode.tenxun.number;

/**
 * @author dengyouquan
 * @createTime 2019-01-25
 **/
public class MajorityElement {
    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 3};
        System.out.println(new MajorityElement().majorityElement1(nums));
    }

    public int majorityElement(int[] nums) {
        int result = 0, count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (count == 0) {
                result = nums[i];
                count++;
            } else if (result == nums[i]) count++;
            else count--;
        }
        return result;
    }

    public int majorityElement1(int[] nums) {
        int result = 0, len = nums.length;
        for (int i = 0; i < 32; i++) {
            int ones = 0, zeros = 0;
            for (int j = 0; j < len; j++) {
                if (ones > len / 2 || zeros > len / 2) break;
                if ((nums[j] & (1 << i)) != 0) ones++;
                else zeros++;
            }
            if (ones > zeros) {
                result |= (1 << i);
            }
        }
        return result;
    }
}
