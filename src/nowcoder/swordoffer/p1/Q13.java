package nowcoder.swordoffer.p1;

import java.util.Arrays;

/**
 * @author dengyouquan
 * @createTime 2019-02-06
 **/
public class Q13 {
    public static void main(String[] args) {
        int[] array = new int[]{1, 3, 2, 6, 7, 10, 5};
        new Q13().reOrderArray(array);
        System.out.println(Arrays.toString(array));
    }

    public void reOrderArray(int[] array) {
        int len;
        if (array == null || (len = array.length) < 2) return;
        int left = 0, right = 0;
        while (left < len) {
            //从左边找到第一个偶数
            while (left < len && (array[left] & 1) == 1) {
                left++;
            }
            //找到第一个奇数
            right = left + 1;
            while (right < len && (array[right] & 1) == 0) {
                right++;
            }
            //右边没有奇数，已完成，break
            if (right == len) break;
            int temp = array[right];
            for (int i = right; i > left; i--) {
                array[i] = array[i - 1];
            }
            array[left] = temp;
        }
    }
}
