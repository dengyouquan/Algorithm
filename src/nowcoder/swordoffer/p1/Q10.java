package nowcoder.swordoffer.p1;

/**
 * @author dengyouquan
 * @createTime 2019-02-06
 **/
public class Q10 {
    public int RectCover(int target) {
        if (target == 0) return 0;
        int a = 1, b = 1;
        while (target-- > 1) {
            a = a + b;
            b = a - b;
        }
        return a;
    }
}
