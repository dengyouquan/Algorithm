package nowcoder.swordoffer.p4;

/**
 * @author dengyouquan
 * @createTime 2019-02-08
 **/
public class Q47 {
    public static void main(String[] args) {
        System.out.println(new Q47().Sum_Solution(4));
    }

    public int Sum_Solution(int n) {
        if (n == 0) return 0;
        return Sum_Solution(n - 1) + n;
    }
}
