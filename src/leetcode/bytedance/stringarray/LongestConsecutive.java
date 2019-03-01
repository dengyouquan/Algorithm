package leetcode.bytedance.stringarray;

import java.util.HashMap;
import java.util.Map;

/**
 * @author dengyouquan
 **/
public class LongestConsecutive {
    public static void main(String[] args) {
        System.out.println(new LongestConsecutive().longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
    }

    public int longestConsecutive(int[] nums) {
        int len;
        if (nums == null || (len = nums.length) == 0) return 0;
        Map<Integer, Integer> map = new HashMap<>();
        int max = 1;
        for (int i : nums) {
            if (map.getOrDefault(i, 0) == 0) {
                int left = map.getOrDefault(i - 1, 0);
                int right = map.getOrDefault(i + 1, 0);
                map.put(i, left + right + 1);
                if (left != 0) {
                    map.put(i - left, left + right + 1);
                }
                if (right != 0) {
                    map.put(i + right, left + right + 1);
                }
                max = (left + right + 1) > max ? (left + right + 1) : max;
            }
        }
        return max;
    }
}
