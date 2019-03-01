package classic;

/**
 * @author dengyouquan
 **/
public class ClimbStairs {
    public static void main(String[] args) {
        System.out.println(new ClimbStairs().climbStairs(5));
    }

    public int climbStairs(int n) {
        if (n < 1) return 0;
        int a = 1, b = 1;
        while (n-- > 1) {
            b = a + b;
            a = b - a;
        }
        return b;
    }
}
