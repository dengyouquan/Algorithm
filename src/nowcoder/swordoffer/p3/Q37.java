package nowcoder.swordoffer.p3;

/**
 * @author dengyouquan
 * @createTime 2019-02-07
 **/
public class Q37 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 3, 3, 3, 4, 5};
        System.out.println(new Q37().GetNumberOfK(nums, 3));
    }

    public int GetNumberOfK(int[] array, int k) {
        int len;
        if (array == null || (len = array.length) == 0) return 0;
        if (k < array[0] || k > array[len - 1]) return 0;
        int firstIndex = getFirstK(array, k);
        int lastIndex = getLastK(array, k);
        if (firstIndex == -1 && lastIndex == -1) return 0;
        return lastIndex - firstIndex + 1;
    }

    private int getFirstK(int[] array, int k) {
        int left = 0, right = array.length - 1;
        if (array[0] == k) return 0;
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (array[mid] < k) {
                left = mid + 1;
            } else if (array[mid] > k) {
                right = mid - 1;
            } else {
                while (array[mid - 1] == k) {
                    mid = mid - 1;
                }
                return mid;
            }
        }
        return -1;
    }

    private int getLastK(int[] array, int k) {
        int left = 0, right = array.length - 1;
        if (array[array.length - 1] == k) return array.length - 1;
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (array[mid] < k) {
                left = mid + 1;
            } else if (array[mid] > k) {
                right = mid - 1;
            } else {
                while (array[mid + 1] == k) {
                    mid = mid + 1;
                }
                return mid;
            }
        }
        return -1;
    }


}
