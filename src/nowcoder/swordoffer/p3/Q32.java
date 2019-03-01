package nowcoder.swordoffer.p3;

import java.util.Arrays;

/**
 * @author dengyouquan
 * @createTime 2019-02-07
 **/
public class Q32 {
    public static void main(String[] args) {
        int[] nums = new int[]{3, 32, 321};
        System.out.println(new Q32().PrintMinNumber(nums));
    }

    public String PrintMinNumber(int[] numbers) {
        int len;
        if (numbers == null || (len = numbers.length) == 0) return "";
        String[] strs = new String[len];
        for (int i = 0; i < len; i++) {
            strs[i] = String.valueOf(numbers[i]);
        }
        Arrays.sort(strs, (o1, o2) -> {
            String s1 = o1 + o2;
            String s2 = o2 + o1;
            return s1.compareTo(s2);
        });
        //System.out.println(Arrays.toString(strs));
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            sb.append(strs[i]);
        }
        return sb.toString();
    }
}
