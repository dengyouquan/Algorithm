package nowcoder.swordoffer.p2;

/**
 * @author dengyouquan
 * @createTime 2019-02-06
 **/
public class Q28 {
    public static void main(String[] args) {
        System.out.println(new Q28().MoreThanHalfNum_Solution(new int[]{1, 2, 3, 2, 2, 2, 5, 4, 2}));
    }

    public int MoreThanHalfNum_Solution(int[] array) {
        if (array.length == 0) return 0;
        int target = 0;
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (count == 0) {
                target = array[i];
                count = 1;
            }
            if (target == array[i]) {
                count++;
            } else {
                count--;
            }
        }
        // 验证是否正确
        count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) count++;
        }
        if (count * 2 > array.length) return target;
        return 0;
    }
}
