package nowcoder.swordoffer.p2;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author dengyouquan
 * @createTime 2019-02-06
 **/
public class Q27 {
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> list = new ArrayList<>();
        if (str.isEmpty()) return list;
        PermutationHelper(str.toCharArray(), 0, list);
        Collections.sort(list);
        return list;
    }

    public void PermutationHelper(char[] cs, int len, ArrayList<String> list) {
        if (len == cs.length - 1) {
            String str = new String(cs);
            if (!list.contains(str)) {
                list.add(str);
            }
        } else {
            for (int i = len; i < cs.length; i++) {
                swap(cs, i, len);
                PermutationHelper(cs, len + 1, list);
                swap(cs, i, len);
            }
        }
    }

    private void swap(char[] cs, int i, int j) {
        char temp = cs[i];
        cs[i] = cs[j];
        cs[j] = temp;
    }
}
