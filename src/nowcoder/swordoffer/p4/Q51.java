package nowcoder.swordoffer.p4;

/**
 * @author dengyouquan
 * @createTime 2019-02-08
 **/
public class Q51 {
    public int[] multiply(int[] A) {
        int len;
        if (A == null || (len = A.length) == 0) return null;
        int[] B = new int[len];
        int left = A[0], right = A[len - 1];
        //计算下三角连乘
        B[0] = 1;
        for (int i = 1; i < len; i++) {
            B[i] = B[i - 1] * A[i - 1];
        }
        int temp = 1;
        for (int i = len - 2; i >= 0; i--) {
            temp *= A[i + 1];
            B[i] *= temp;
        }
        return B;
    }
}
