package nowcoder.swordoffer.p4;

/**
 * @author dengyouquan
 * @createTime 2019-02-08
 **/
public class Q54 {
    public static void main(String[] args) {
        Q54 q = new Q54();
        q.Insert('g');
        q.Insert('o');
        q.Insert('g');
        q.Insert('g');
        System.out.println(q.FirstAppearingOnce());
    }

    char[] hash = new char[256];
    StringBuilder sb = new StringBuilder();

    //Insert one char from stringstream
    public void Insert(char ch) {
        hash[ch]++;
        sb.append(ch);
    }

    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce() {
        for (int i = 0; i < sb.length(); i++) {
            if (hash[sb.charAt(i)] == 1) return sb.charAt(i);
        }
        return '#';
    }
}
