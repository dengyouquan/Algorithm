package nowcoder.swordoffer.p1;

/**
 * @author dengyouquan
 * @createTime 2019-02-06
 **/
public class Q7 {
    public int Fibonacci(int n) {
        int a = 0, b = 1;
        while (n-- > 0) {
            a = a + b;
            b = a - b;
        }
        return a;
    }
}
