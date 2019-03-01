package leetcode.tenxun.arraystring;

/**
 * @author dengyouquan
 **/
public class Multiply {
    public static void main(String[] args) {
        System.out.println(new Multiply().multiply("123", "456"));
        //System.out.println(new Multiply().multiply("9133", "0"));
    }

    public String multiply(String num1, String num2) {
        int len1 = num1.length(), len2 = num2.length();
        if (len1 > len2) return multiply(num2, num1);
        //0值判断
        if (num1.equals("0")) return num1;
        StringBuilder sum = new StringBuilder();
        for (int i = len1 - 1; i >= 0; i--) {
            StringBuilder add = multiply(num1.charAt(i), num2);
            for (int j = 0; j < len1 - 1 - i; j++) {
                add.append('0');
            }
            sum = add(sum, add);
        }
        return sum.toString();
    }

    private StringBuilder multiply(char num1, String num2) {
        int len = num2.length();
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = len - 1; i >= 0; i--) {
            int a = num2.charAt(i) - '0';
            int b = a * (num1 - '0') + carry;
            sb.insert(0, b % 10);
            carry = b / 10;
        }
        if (carry > 0) sb.insert(0, carry);
        return sb;
    }

    private StringBuilder add(StringBuilder add1, StringBuilder add2) {
        int len1 = add1.length(), len2 = add2.length();
        if (len1 < len2) return add(add2, add1);
        StringBuilder sum = new StringBuilder();
        int carry = 0;
        int i = len1 - 1, j = len2 - 1;
        for (; i >= 0 && j >= 0; i--, j--) {
            int s = (add1.charAt(i) - '0') + (add2.charAt(j) - '0') + carry;
            sum.insert(0, s % 10);
            carry = s >= 10 ? 1 : 0;
        }
        while (i >= 0) {
            int s = (add1.charAt(i--) - '0') + carry;
            sum.insert(0, s % 10);
            carry = s >= 10 ? 1 : 0;
        }
        if (carry == 1) sum.insert(0, 1);
        return sum;
    }
}
