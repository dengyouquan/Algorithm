package leetcode.tenxun.arraystring;

import java.util.Arrays;

/**
 * @author dengyouquan
 **/
public class RemoveDuplicates {
    public static void main(String[] args) {
        //int[] nums = new int[]{1};
        int[] nums = new int[]{1, 1};
        //int[] nums = new int[]{1, 2};
        //int[] nums = new int[]{1, 1, 1};
        //int[] nums = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println(new RemoveDuplicates().removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));
    }

    public int removeDuplicates(int[] nums) {
        if (nums == null) return 0;
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[index] != nums[i]) {
                nums[++index] = nums[i];
            }
        }
        return ++index;
    }
}
