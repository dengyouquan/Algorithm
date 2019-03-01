package leetcode.tenxun.arraystring;

import java.util.Arrays;

/**
 * @author dengyouquan
 * @createTime 2019-01-23
 **/
public class ReverseWords {
    public static void main(String[] args) {
        System.out.println(new ReverseWords().reverseWords("s ab"));
    }

    public String reverseWords(String s) {
        char[] cs = s.toCharArray();
        int len;
        if ((len = cs.length) < 2) return s;
        int index = 0;
        for (int i = 0; i < len; i++) {
            if (cs[i] == ' ') {
                reverseString(cs, index, i - 1);
                index = i + 1;
            }
        }
        if (index < len) {
            reverseString(cs, index, len - 1);
        }
        return new String(cs);
    }

    private void reverseString(char[] s, int a, int b) {
        int left = a - 1, right = b + 1;
        while (++left < --right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
        }
    }
}
