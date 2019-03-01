package leetcode.tenxun.number;

/**
 * @author dengyouquan
 * @createTime 2019-01-25
 **/
public class IsPowerOfTwo {
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) return false;
        return (n & (n - 1)) == 0;
    }
}
