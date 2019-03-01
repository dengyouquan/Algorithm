package leetcode.bytedance.other;

/**
 * @author dengyouquan
 **/
public class MySqrt {
    public static void main(String[] args) {
        System.out.println(new MySqrt().mySqrt(8));
    }

    public int mySqrt(int x) {
        if (x <= 1) return x;
        int left = 0, right = x;
        while (left < right) {
            int mid = left + (right - left >> 1);
            if (x / mid >= mid) left = mid + 1;
            else right = mid;
        }
        return right - 1;
    }
}
