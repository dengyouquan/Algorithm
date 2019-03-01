package leetcode.tenxun.arraystring;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author dengyouquan
 **/
public class IsValid {
    public static void main(String[] args) {
        System.out.println(new IsValid().isValid("{()}"));
    }

    public boolean isValid(String s) {
        if (s == null || s.length() == 0) return true;
        Deque<Character> stack = new ArrayDeque<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (c == ')') {
                if (!isMatch('(', stack)) return false;
            } else if (c == ']') {
                if (!isMatch('[', stack)) return false;
            } else if (c == '}') {
                if (!isMatch('{', stack)) return false;
            } else stack.addLast(c);
        }
        if (stack.isEmpty()) return true;
        return false;
    }

    private boolean isMatch(char r, Deque<Character> stack) {
        if (stack.isEmpty()) return false;
        char c = stack.pollLast();
        if (r == c) return true;
        return false;
    }
}
