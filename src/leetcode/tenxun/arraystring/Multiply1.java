package leetcode.tenxun.arraystring;

import java.util.Arrays;

/**
 * @author dengyouquan
 **/
public class Multiply1 {
    public static void main(String[] args) {
        //System.out.println(new Multiply1().multiply("123", "456"));
        System.out.println(new Multiply1().multiply("9133", "0"));
    }

    public String multiply(String num1, String num2) {
        char[] char1 = num1.toCharArray();
        char[] char2 = num2.toCharArray();
        int len1 = char1.length;
        int len2 = char2.length;
        int[] result = new int[len1 + len2];
        int[] a = new int[len1];
        int[] b = new int[len2];
        //转为 int 数组
        for (int i = 0; i < len1; i++) {
            a[i] = char1[i] - '0';
        }
        for (int i = 0; i < len2; i++) {
            b[i] = char2[i] - '0';
        }
        //反向相乘 AB*CD = AC(BC+AD)BD , 然后进位
        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < len2; j++) {
                result[len1 + len2 - 2 - i - j] += a[i] * b[j];
            }
        }
        //System.out.println(Arrays.toString(result));
        //进位
        for (int i = 0; i < len1 + len2 - 1; i++) {
            result[i + 1] += result[i] / 10;
            result[i] = result[i] % 10;
        }
        //System.out.println(Arrays.toString(result));
        //转为字符串
        boolean isZero = false;
        StringBuilder sb = new StringBuilder();
        for (int i = len1 + len2 - 1; i >= 0; i--) {
            if (result[i] != 0) isZero = true;
            if (isZero) {
                sb.append(result[i]);
            }
        }
        //边界值
        if (sb.toString().equals("")) return "0";
        return sb.toString();
    }
}
