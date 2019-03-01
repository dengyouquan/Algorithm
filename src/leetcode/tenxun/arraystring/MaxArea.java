package leetcode.tenxun.arraystring;

/**
 * @author dengyouquan
 **/
public class MaxArea {
    public static void main(String[] args) {
        int[] height = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(new MaxArea().maxArea(height));
    }

    public int maxArea(int[] height) {
        int len;
        if (height == null || (len = height.length) == 0) return 0;
        int left = 0, right = len - 1, maxArea = 0;
        while (left < right) {
            int area = Math.min(height[left], height[right]) * (right - left);
            maxArea = Math.max(area, maxArea);
            if (height[left] < height[right]) left++;
            else right--;
        }
        return maxArea;
    }
}
