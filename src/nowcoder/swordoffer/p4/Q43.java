package nowcoder.swordoffer.p4;

/**
 * @author dengyouquan
 * @createTime 2019-02-08
 **/
public class Q43 {
    public static void main(String[] args) {
        System.out.println(new Q43().LeftRotateString("abcXYZdef", 3));
    }

    public String LeftRotateString(String str, int n) {
        if (str.isEmpty()) return str;
        n %= str.length();
        char[] cs = str.toCharArray();
        for (int i = 0, j = n - 1; i < j; i++, j--) {
            swap(cs, i, j);
        }
        for (int i = n, j = str.length() - 1; i < j; i++, j--) {
            swap(cs, i, j);
        }
        for (int i = 0, j = str.length() - 1; i < j; i++, j--) {
            swap(cs, i, j);
        }
        return new String(cs);
    }

    private void swap(char[] cs, int i, int j) {
        char temp = cs[i];
        cs[i] = cs[j];
        cs[j] = temp;
    }
}
