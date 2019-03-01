package nowcoder.swordoffer.p2;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author dengyouquan
 * @createTime 2019-02-06
 **/
public class Q29 {
    //超时，不知道为什么
    public static void main(String[] args) {
        int[] nums = new int[]{4, 5, 1, 6, 2, 7, 3, 8};
        System.out.println(new Q29().GetLeastNumbers_Solution(nums, -231));
    }

    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        if (k <= 0 || input == null || input.length == 0) return list;
        int start = 0;
        int end = input.length - 1;
        //不判断当k大于len会死循环
        if (k <= end + 1) {
            int index = partition(input, k, list, start, end);
            while (index != k - 1) {
                if (index < k - 1) {
                    end = index - 1;
                    index = partition(input, k, list, start, end);
                } else if (index > k - 1) {
                    start = index + 1;
                    index = partition(input, k, list, start, end);
                }
            }
        } else {
            k = end + 1;
        }
        for (int i = 0; i < k; i++) {
            list.add(input[i]);
        }
        Collections.sort(list);
        return list;
    }

    private int partition(int[] input, int k, ArrayList<Integer> list, int start, int end) {
        int pivot = input[start];
        int left = start;
        int right = end;
        while (left < right) {
            while (left < right && input[right] > pivot) right--;
            input[left] = input[right];
            while (left < right && input[left] <= pivot) left++;//2 3 2 1 3 2
            input[right] = input[left];
        }
        input[left] = pivot;
        return left;
    }
}
