package leetcode.bytedance.stringarray;

/**
 * @author dengyouquan
 **/
public class LengthOfLongestSubstring {
    public static void main(String[] args) {
        System.out.println(new LengthOfLongestSubstring().lengthOfLongestSubstring("abcabcbb"));
    }

    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        int maxLen = 0;
        int[] map = new int[128];
        for (int i = 0, j = 0; j < len; j++) {
            i = Math.max(map[s.charAt(j)], i);
            maxLen = Math.max(maxLen, j - i + 1);
            map[s.charAt(j)] = j + 1;
        }
        return maxLen;
    }
}
