package leetcode.tenxun.arraystring;

import java.util.Arrays;

/**
 * @author dengyouquan
 * @createTime 2019-01-24
 **/
public class Merge {
    public static void main(String[] args) {
        /*int[] nums1 = new int[]{1, 2, 3, 0, 0, 0};
        int[] nums2 = new int[]{4, 5, 6};
        new Merge().merge(nums1, 3, nums2, 3);*/
        int[] nums1 = new int[]{2};
        int[] nums2 = new int[]{1};
        new Merge().merge(nums1, 0, nums2, 1);
        System.out.println(Arrays.toString(nums1));
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index = m + n - 1;
        int index1 = m - 1, index2 = n - 1;
        while (index >= 0) {
            if (index1 < 0) {
                nums1[index--] = nums2[index2--];
            } else if (index2 < 0) {
                nums1[index--] = nums1[index1--];
            } else if (nums2[index2] > nums1[index1]) {
                nums1[index--] = nums2[index2--];
            } else {
                nums1[index--] = nums1[index1--];
            }
        }
    }
}
