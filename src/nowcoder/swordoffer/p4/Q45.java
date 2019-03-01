package nowcoder.swordoffer.p4;

/**
 * @author dengyouquan
 * @createTime 2019-02-08
 **/
public class Q45 {
    public static void main(String[] args) {
        int[] numbers = new int[]{1, 3, 2, 6, 4};
        System.out.println(new Q45().isContinuous(numbers));
    }

    public boolean isContinuous(int[] numbers) {
        if (numbers == null || numbers.length != 5) return false;
        int max = -1;
        int min = 14;
        short flag = 0;
        for (int i = 0; i < numbers.length; i++) {
            int number = numbers[i];
            if (number < 0 || number > 13) return false;
            if (number == 0) continue;
            //重复数字
            if (((flag >> number) & 1) == 1) return false;
            flag |= (1 << number);
            if (number > max) max = number;
            if (number < min) min = number;
            if (max - min >= 5) return false;
        }
        return true;
    }
}
