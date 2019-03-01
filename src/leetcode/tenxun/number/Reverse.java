package leetcode.tenxun.number;

/**
 * @author dengyouquan
 * @createTime 2019-01-25
 **/
public class Reverse {
    public static void main(String[] args) {
        System.out.println(new Reverse().reverse(123));
    }

    public int reverse(int x) {
        int reverseNum = 0;
        while (x != 0) {
            int mod = x % 10;
            x /= 10;
            if (reverseNum > Integer.MAX_VALUE / 10 || (reverseNum == Integer.MAX_VALUE / 10 && mod > 7)) return 0;
            if (reverseNum < Integer.MIN_VALUE / 10 || (reverseNum == Integer.MIN_VALUE / 10 && mod < -8)) return 0;
            reverseNum = reverseNum * 10 + mod;
        }
        return reverseNum;
    }
}
