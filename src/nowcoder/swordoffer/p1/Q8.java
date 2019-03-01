package nowcoder.swordoffer.p1;

/**
 * @author dengyouquan
 * @createTime 2019-02-06
 **/
public class Q8 {
    public static void main(String[] args) {
        System.out.println(new Q8().JumpFloor(2));
    }
    public int JumpFloor(int target) {
        int a = 1, b = 1;
        while (target-- > 1) {
            a = a + b;
            b = a - b;
        }
        return a;
    }
}
