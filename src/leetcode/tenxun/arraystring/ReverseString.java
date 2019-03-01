package leetcode.tenxun.arraystring;

import java.util.Arrays;

/**
 * @author dengyouquan
 **/
public class ReverseString {
    public static void main(String[] args) {
        char[] s = new char[]{'h', 'e', 'l', 'l', 'o'};
        System.out.println(Arrays.toString(s));
        new ReverseString().reverseString2(s);
        System.out.println(Arrays.toString(s));
    }

    //双指针
    public void reverseString(char[] s) {
        int len;
        if (s == null || (len = s.length) < 2) return;
        int left = -1, right = len;
        while (++left < --right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
        }
    }

    //对半交换
    public void reverseString2(char[] s) {
        int len;
        if (s == null || (len = s.length) < 2) return;
        for (int i = (len - 1) >> 1; i >= 0; i--) {
            char temp = s[i];
            s[i] = s[len - 1 - i];
            s[len - 1 - i] = temp;
        }
    }
}
