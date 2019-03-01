package nowcoder.swordoffer.p3;

/**
 * @author dengyouquan
 * @createTime 2019-02-07
 **/
public class Q34 {
    public static void main(String[] args) {
        System.out.println(new Q34().FirstNotRepeatingChar("google"));
    }

    public int FirstNotRepeatingChar(String str) {
        if (str.isEmpty()) return -1;
        short[] map = new short[127];
        char[] cs = str.toCharArray();
        for (int i = 0; i < cs.length; i++) {
            map[cs[i]]++;
        }
        for (int i = 0; i < cs.length; i++) {
            if (map[cs[i]] == 1) {
                return i;
            }
        }
        return -1;
    }
}
