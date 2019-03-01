package leetcode.primary.array;

import java.util.Arrays;

/**
 * @author dengyouquan
 * @createTime 2019-02-09
 **/
public class RemoveDuplicates {
    public static void main(String[] args) {
        int[] nums = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println(new RemoveDuplicates().removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));
    }

    public int removeDuplicates(int[] nums) {
        int len;
        if (nums == null || (len = nums.length) == 0) return 0;
        int originIndex = 1, newIndex = 0;
        while (originIndex < len) {
            while (originIndex < len && nums[originIndex] == nums[newIndex]) {
                originIndex++;
            }
            if (originIndex < len && originIndex != newIndex) {
                nums[++newIndex] = nums[originIndex];
            }
        }
        return newIndex + 1;
    }
}
