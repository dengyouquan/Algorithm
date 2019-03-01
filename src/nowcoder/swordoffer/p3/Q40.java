package nowcoder.swordoffer.p3;

/**
 * @author dengyouquan
 * @createTime 2019-02-07
 **/
public class Q40 {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 4, 3, 6, 3, 2, 5, 5};
        int[] num1 = new int[1];
        int[] num2 = new int[1];
        new Q40().FindNumsAppearOnce(nums, num1, num2);
        System.out.println(num1[0] + "," + num2[0]);
    }

    public void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {
        int len;
        if (array == null || (len = array.length) == 0) {
            num1[0] = 0;
            num2[0] = 0;
            return;
        }
        int sum = 0, index = 0;
        for (int i = 0; i < len; i++) {
            sum ^= array[i];
        }
        //找出第一个为1的位
        for (; index < 32; index++) {
            if ((sum & (1 << index)) != 0) break;
        }
        //用这个位分成两个数组，分别求[一个数组有一个出现一次的数字，其他数字都出现两次]的问题
        for (int i = 0; i < len; i++) {
            if ((array[i] & (1 << index)) != 0) {
                num1[0] ^= array[i];
            } else {
                num2[0] ^= array[i];
            }
        }
    }
}
