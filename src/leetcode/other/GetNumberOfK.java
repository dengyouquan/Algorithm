package leetcode.other;

/**
 * @author dengyouquan
 * @createTime 2019-01-25
 **/
public class GetNumberOfK {
    public static void main(String[] args) {
        int[] array = new int[]{1, 1, 1, 2};
        System.out.println(new GetNumberOfK().GetNumberOfK(array, 1));
    }

    public int GetNumberOfK(int[] array, int k) {
        int len;
        if (array == null || (len = array.length) == 0) return 0;
        int left = getFirstK(array, k, 0, len - 1);
        int right = getLastK(array, k, 0, len - 1);
        if (left == -1 || right == -1) return 0;
        return right - left + 1;
    }

    private int getFirstK(int[] array, int k, int left, int right) {
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (array[mid] < k) {
                right = mid - 1;
            } else if (array[mid] > k) {
                left = mid + 1;
            } else {
                if ((mid == 0) || (mid > 0 && array[mid - 1] != k)) {
                    return mid;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

    private int getLastK(int[] array, int k, int left, int right) {
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (array[mid] < k) {
                right = mid - 1;
            } else if (array[mid] > k) {
                left = mid + 1;
            } else {
                if ((mid == 0) || (mid > 0 && array[mid + 1] != k)) {
                    return mid;
                } else {
                    left = mid + 1;
                }
            }
        }
        return -1;
    }

}
