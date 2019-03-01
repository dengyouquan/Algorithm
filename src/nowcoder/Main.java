package nowcoder;

import java.util.List;


/**
 * @author dengyouquan
 * @createTime 2019-02-05
 **/
public class Main {
    public static void main(String[] args) {
        System.out.println(lowbit(3));
        System.out.println(Integer.toBinaryString(0));
    }

    public static int negative(int n) {
        /**
         * 0001(1) ^ 0000(0) = 0001(1)
         * 0010(2) ^ 0001(1) = 0011(3)
         * 0011(3) ^ 0010(2) = 0001(1)
         */
        return n ^ (n - 1);
    }

    public static int lowbit(int n) {
        /**
         * 0001(1) & 1111(-1) = 0001(1)
         * 0010(2) & 1110(-2) = 0010(2)
         * 0011(2) & 1101(-3) = 0001(1)
         */
        return n & -n;
    }
}
