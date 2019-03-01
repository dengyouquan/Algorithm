package nowcoder.swordoffer.p4;

/**
 * @author dengyouquan
 * @createTime 2019-02-08
 **/
public class Q49 {
    public static void main(String[] args) {
        System.out.println(new Q49().StrToInt("1a33"));
    }

    public int StrToInt(String str) {
        int len;
        if (str == null || (len = str.length()) == 0) return 0;
        char[] cs = str.toCharArray();
        long result = 0;
        boolean negative = false;
        for (int i = 0; i < len && i < 12; i++) {
            if (i == 0 && (cs[i] == '-' || cs[i] == '+')) {
                negative = cs[i] == '-';
                continue;
            }
            if (cs[i] < '0' || cs[i] > '9') return 0;
            result = result * 10 + cs[i] - '0';
        }
        result = negative ? -result : result;
        if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) return 0;
        return (int) result;
    }
}
