package nowcoder.swordoffer.p4;

import java.util.ArrayList;

/**
 * @author dengyouquan
 * @createTime 2019-02-08
 **/
public class Q42 {
    public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
        ArrayList<Integer> list = new ArrayList<>();
        int len;
        if (array == null || (len = array.length) == 0) return list;
        int left = 0, right = len - 1;
        while (left < right) {
            int target = array[left] + array[right];
            if (target == sum) {
                list.add(array[left]);
                list.add(array[right]);
                break;
            } else if (target < sum) {
                left++;
            } else {
                right--;
            }
        }
        return list;
    }
}
