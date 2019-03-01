package leetcode.tenxun.sortsearch;

/**
 * @author dengyouquan
 * @createTime 2019-01-26
 **/
public class Search {
    public static void main(String[] args) {
        int[] nums = new int[]{3, 5, 1};
        System.out.println(new Search().search(nums, 3));
    }

    public int search(int[] nums, int target) {
        int len;
        if (nums == null || (len = nums.length) == 0) return -1;
        int left = 0, right = len - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] == target) return mid;
            else if (nums[mid] < nums[right]) {
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return -1;
    }
}
