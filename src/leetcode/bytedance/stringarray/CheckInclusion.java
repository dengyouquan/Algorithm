package leetcode.bytedance.stringarray;

import java.util.Arrays;

/**
 * @author dengyouquan
 **/
public class CheckInclusion {
    public static void main(String[] args) {

    }

    public boolean checkInclusion(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        int[] map1 = new int[26];
        int[] map2 = new int[26];
        for (char c : s1.toCharArray()) {
            map1[c - 'a']++;
        }
        for (int i = 0; i < len2; i++) {
            if (i >= len1) {
                --map2[s2.charAt(i - len1) - 'a'];
            }
            map2[s2.charAt(i) - 'a']++;
            if (Arrays.equals(map1, map2)) return true;
        }
        return false;
    }
}
