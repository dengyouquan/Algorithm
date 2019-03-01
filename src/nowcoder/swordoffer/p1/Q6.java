package nowcoder.swordoffer.p1;

/**
 * @author dengyouquan
 * @createTime 2019-02-05
 **/
public class Q6 {
    public static void main(String[] args) {
        int[] nums = new int[]{3, 4, 5, 1, 2};
        System.out.println(new Q6().minNumberInRotateArray(nums));
    }

    public int minNumberInRotateArray(int[] array) {
        int len = array.length;
        if (len == 0) return 0;
        int left = 0, right = len - 1;
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (array[right] > array[mid]) {
                right = mid;
            } else if (array[right] < array[mid]) {
                left = mid + 1;
            } else {
                right = right - 1;
            }
        }
        return array[left];
    }
}
