package classic;

/**
 * @author dengyouquan
 **/
public class LongestPalindrome {
    public static void main(String[] args) {
        System.out.println(new LongestPalindrome().longestPalindrome("cabcaa"));
    }

    public int longestPalindrome(String s) {
        int len;
        if (s == null || (len = s.length()) < 1) return 0;
        String s1 = init(s);
        int id = 0, mx = 0, max = 0;
        int[] p = new int[s1.length() + 1];
        for (int i = 0; i < len; i++) {
            if (id < mx) {
                p[i] = Math.min(p[2 * id - i], mx - i);
            } else {
                p[i] = 1;
            }
            while (s1.charAt(i - p[i]) == s1.charAt(i + p[i])) p[i]++;
            if (mx < i + p[i]) {
                id = i;
                mx = i + p[i];
            }
            max = Math.max(max, p[i] - 1);
        }
        return max;
    }

    private String init(String s) {
        StringBuilder sb = new StringBuilder();
        sb.append("$");
        sb.append("#");
        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i));
            sb.append("#");
        }
        sb.append("\0");
        return sb.toString();
    }

    //动态规划 O(n^2)
    public String longestPalindrome2(String s) {
        int len;
        if (s == null || (len = s.length()) < 1) return s;
        int start = 0, end = 0;
        boolean[][] dp = new boolean[len][len];
        for (int i = len - 1; i >= 0; i--) {
            dp[i][i] = true;
            for (int j = i + 1; j < len; j++) {
                // i j相邻时或者前一个为回文串时
                dp[i][j] = s.charAt(i) == s.charAt(j) && (j == i + 1 || dp[i + 1][j - 1]);
                if (dp[i][j] && end - start < j - i) {
                    end = j;
                    start = i;
                }
            }
        }
        return s.substring(start, end + 1);
    }

    //中心扩展法 O(n^2)
    public String longestPalindrome1(String s) {
        int len;
        if (s == null || (len = s.length()) < 1) return s;
        int start = 0, end = 0;
        for (int i = 0; i < len; i++) {
            int len1 = expandFromCenter(s, i, i);
            int len2 = expandFromCenter(s, i, i + 1);
            int max = Math.max(len1, len2);
            if (max > end - start) {
                start = i - (max - 1) / 2;
                end = i + max / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int expandFromCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }
}
