package nowcoder.swordoffer.p4;

/**
 * @author dengyouquan
 * @createTime 2019-02-08
 **/
public class Q48 {
    public int Add(int num1, int num2) {
        while (num2 != 0) {
            int temp = num1 ^ num2;
            num2 = (num1 & num2) << 1;
            num1 = temp;
        }
        return num1;
    }
}
