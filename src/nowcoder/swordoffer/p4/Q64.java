package nowcoder.swordoffer.p4;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

/**
 * @author dengyouquan
 * @createTime 2019-02-08
 **/
public class Q64 {
    public static void main(String[] args) {
        int[] num = new int[]{2, 3, 4, 2, 6, 2, 5, 1};
        System.out.println(new Q64().maxInWindows(num, 3));
    }

    /**
     * 用一个双端队列，队列第一个位置保存当前窗口的最大值，当窗口滑动一次
     * 1.判断当前最大值是否过期
     * 2.新增加的值从队尾开始比较，把所有比他小的值丢掉
     */
    public ArrayList<Integer> maxInWindows(int[] num, int size) {
        ArrayList<Integer> list = new ArrayList<>();
        if (size == 0) return list;
        int begin = -size;
        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < num.length; i++) {
            begin++;
            if (queue.isEmpty()) {
                queue.addLast(i);
            } else if (begin > queue.peekFirst()) {
                //是否移除最大元素
                queue.pollFirst();
            }
            while (!queue.isEmpty() && num[queue.peekLast()] <= num[i]) queue.pollLast();
            queue.addLast(i);
            if (begin >= 0) list.add(num[queue.peekFirst()]);
        }
        return list;
    }
}
