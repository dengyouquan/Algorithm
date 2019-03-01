package leetcode.tenxun.number;

/**
 * @author dengyouquan
 * @createTime 2019-01-25
 **/
public class IsPalindrome {
    public boolean isPalindrome(int x) {
        if (x == 0) return true;
        if (x < 0 || x % 10 == 0) return false;
        int reverseX = 0;
        while (x > reverseX) {
            reverseX = reverseX * 10 + x % 10;
            x /= 10;
        }
        return reverseX == x || reverseX / 10 == x;
    }
}
