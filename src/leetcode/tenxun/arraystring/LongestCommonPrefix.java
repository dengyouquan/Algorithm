package leetcode.tenxun.arraystring;

/**
 * @author dengyouquan
 **/
public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] strs = {"flower","flow","flight"};
        System.out.println(new LongestCommonPrefix().longestCommonPrefix(strs));
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        int i = 0;
        for (; i < strs[0].length(); i++) {
            boolean equal = true;
            for (int j = 1; j < strs.length; j++) {
                if (i >= strs[j].length() || strs[0].charAt(i) != strs[j].charAt(i)) {
                    equal = false;
                    break;
                }
            }
            if (!equal) break;
        }
        return strs[0].substring(0, i);
    }
}
