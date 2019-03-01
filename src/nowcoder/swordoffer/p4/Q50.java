package nowcoder.swordoffer.p4;

/**
 * @author dengyouquan
 * @createTime 2019-02-08
 **/
public class Q50 {
    public boolean duplicate(int numbers[], int length, int[] duplication) {
        boolean[] k = new boolean[length];
        for (int i = 0; i < length; i++) {
            if (k[numbers[i]]) {
                duplication[0] = numbers[i];
                return true;
            }
            k[numbers[i]] = true;
        }
        return false;
    }
}
