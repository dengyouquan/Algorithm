package leetcode.tenxun.arraystring;

/**
 * @author dengyouquan
 **/
public class MyAtoi {
    public static void main(String[] args) {
        System.out.println(new MyAtoi().myAtoi("2147483648"));
    }

    public int myAtoi(String str) {
        int len;
        if (str == null || (len = str.length()) < 1) return 0;
        //find number
        int i = 0;
        for (; i < len; i++) {
            if (str.charAt(i) == ' ') continue;
            if ('0' <= str.charAt(i) && str.charAt(i) <= '9') {
                break;
            } else if (str.charAt(i) == '+' || (str.charAt(i) == '-')) {
                if (++i < len && '0' <= str.charAt(i) && str.charAt(i) <= '9') {
                    break;
                } else return 0;
            } else return 0;
        }
        //no number
        if (i == len) return 0;
        String numStr = "";
        boolean minus = false;
        if (i > 0 && str.charAt(i - 1) == '-') minus = true;
        for (; i < len; i++) {
            if ('0' <= str.charAt(i) && str.charAt(i) <= '9') {
                numStr += str.charAt(i);
            } else {
                break;
            }
        }
        for (i = 0; i < numStr.length(); i++) {
            if ('0' != numStr.charAt(i)) break;
        }
        numStr = numStr.substring(i);
        //System.out.println(numStr);
        //convert number
        long number = 0;
        boolean flag = false;
        len = numStr.length();
        if (len > 10) return minus ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        for (i = len - 1; i >= 0; i--) {
            int a = (int) ((numStr.charAt(i) - '0') * Math.pow(10, len - 1 - i));
            number += a;
        }
        number = minus ? -number : number;
        if (number < Integer.MIN_VALUE) return Integer.MIN_VALUE;
        if (number > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        return (int) number;
    }
}
