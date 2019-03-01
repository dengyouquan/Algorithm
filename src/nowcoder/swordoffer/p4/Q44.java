package nowcoder.swordoffer.p4;

/**
 * @author dengyouquan
 * @createTime 2019-02-08
 **/
public class Q44 {
    public static void main(String[] args) {
        System.out.println(new Q44().ReverseSentence("student. a am I"));
    }

    public String ReverseSentence(String str) {
        if (str == null || str.trim().equals("")) return str;
        StringBuilder sb = new StringBuilder();
        String[] strings = str.split(" ");
        for (int i = strings.length; i > 0; i--) {
            sb.append(strings[i - 1]);
            if (i > 1) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}
