package leetcode.tenxun.sortsearch;

import java.util.PriorityQueue;

/**
 * @author dengyouquan
 * @createTime 2019-01-26
 **/
public class FindKthLargest {
    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 1, 5, 6, 4};
        System.out.println(new FindKthLargest().findKthLargest2(nums, 2));
    }

    public int findKthLargest2(int[] nums, int k) {
        int len = nums.length;
        PriorityQueue<Integer> heap = new PriorityQueue<>();// 小顶堆
        for (int i = 0; i < len; i++) {
            heap.add(nums[i]);
            if (heap.size() > k) {
                heap.poll();
            }
        }
        return heap.peek();
    }

    public int findKthLargest(int[] nums, int k) {
        int len = nums.length;
        partition(nums, 0, len - 1, len - k);
        return nums[len - k];
    }

    private void partition(int[] nums, int left, int right, int k) {
        int mid = nums[left];
        int l = left, r = right;
        while (l < r) {
            while (l < r && nums[r] >= mid) r--;
            nums[l] = nums[r];
            while (l < r && nums[l] <= mid) l++;
            nums[r] = nums[l];
        }
        nums[l] = mid;
        //top k
        if (l > k) {
            partition(nums, left, l - 1, k);
        } else if (l < k) {
            partition(nums, l + 1, right, k);
        }
    }
}
