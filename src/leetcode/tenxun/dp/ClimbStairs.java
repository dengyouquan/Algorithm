package leetcode.tenxun.dp;

/**
 * @author dengyouquan
 * @createTime 2019-01-26
 **/
public class ClimbStairs {
    public int climbStairs(int n) {
        if (n < 1) return 0;
        int a = 1, b = 1;
        while (n-- > 1) {
            a = a + b;
            b = a - b;
        }
        return a;
    }
}
