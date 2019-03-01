package leetcode.tenxun.arraystring;

/**
 * @author dengyouquan
 **/
public class FindMedianSortedArrays {
    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 3};
        int[] nums2 = new int[]{2, 4};
        System.out.println(new FindMedianSortedArrays().findMedianSortedArrays(nums1, nums2));
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int mid1 = (m + n) >> 1;
        int mid2 = (m + n - 1) >> 1;
        int index1 = 0, index2 = 0;
        int sum = 0;
        int i = 0;
        boolean flag = false;
        while (i <= mid1 || i <= mid2) {
            if (index1 < m && index2 < n && nums1[index1] < nums2[index2]) {
                index1++;
                flag = false;
            } else if (index1 < m && index2 < n && nums1[index1] >= nums2[index2]) {
                index2++;
                flag = true;
            } else {
                if (index1 == m) {
                    index2++;
                    flag = true;
                } else {
                    index1++;
                    flag = false;
                }
            }
            if (i == mid1) {
                if (flag) {
                    sum += nums2[index2 - 1];
                } else {
                    sum += nums1[index1 - 1];
                }
            }
            if (i == mid2) {
                if (flag) {
                    sum += nums2[index2 - 1];
                } else {
                    sum += nums1[index1 - 1];
                }
            }
            i++;
        }
        return sum * 1.0 / 2;
    }
}
