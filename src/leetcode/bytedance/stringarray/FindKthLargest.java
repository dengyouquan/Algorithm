package leetcode.bytedance.stringarray;

/**
 * @author dengyouquan
 **/
public class FindKthLargest {
    public static void main(String[] args) {
        System.out.println(new FindKthLargest().findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));
    }

    public int findKthLargest(int[] nums, int k) {
        int len;
        if (nums == null || (len = nums.length) == 0) return 0;
        if (k > len || k < 0) return 0;
        //len-k是第k大的数
        return partition(nums, len - k, 0, len - 1);
    }

    private int partition(int[] nums, int k, int start, int end) {
        int temp = nums[start], i = start, j = end;
        while (i < j) {
            while (i < j && nums[j] >= temp) j--;
            nums[i] = nums[j];
            while (i < j && nums[i] <= temp) i++;
            nums[j] = nums[i];
        }
        nums[i] = temp;
        if (i == k) {
            return nums[i];
        } else if (i > k) {
            return partition(nums, k, start, i - 1);
        } else {
            return partition(nums, k, i + 1, end);
        }
    }
}
