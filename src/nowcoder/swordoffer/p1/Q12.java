package nowcoder.swordoffer.p1;

/**
 * @author dengyouquan
 * @createTime 2019-02-06
 **/
public class Q12 {
    public static void main(String[] args) {
        System.out.println(new Q12().Power(2, -3));
    }

    public double Power(double base, int exponent) {
        if (exponent < 0) return Power(1.0 / base, -exponent);
        double sum = 1;
        while (exponent > 0) {
            if ((exponent & 1) == 1) {
                sum *= base;
            }
            base *= base;
            exponent >>= 1;
        }
        return sum;
    }
}
