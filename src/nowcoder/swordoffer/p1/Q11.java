package nowcoder.swordoffer.p1;


/**
 * @author dengyouquan
 * @createTime 2019-02-06
 **/
public class Q11 {
    public static void main(String[] args) {
        System.out.println(new Q11().NumberOf1(-1));
    }

    public int NumberOf1(int n) {
        int count = 0;
        while (n != 0) {
            if ((n & 1) == 1) count++;
            //无符号位移
            n >>>= 1;
        }
        return count;
    }
}
