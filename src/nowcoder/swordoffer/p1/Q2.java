package nowcoder.swordoffer.p1;

/**
 * @author dengyouquan
 * @createTime 2019-02-05
 **/
public class Q2 {
    public String replaceSpace(StringBuffer str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                sb.append("%20");
            } else {
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }
}
