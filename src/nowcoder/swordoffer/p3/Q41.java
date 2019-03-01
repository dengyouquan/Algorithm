package nowcoder.swordoffer.p3;

import java.util.ArrayList;

/**
 * @author dengyouquan
 * @createTime 2019-02-07
 **/
public class Q41 {
    //双指针
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        int left = 1, right = 2;
        //两个起点，相当于动态窗口的两边，根据其窗口内的值的和来确定窗口的位置和大小
        while (right > left) {
            //由于是连续的，差为1的一个序列，那么求和公式是(a0+an)*n/2
            int curSum = (left + right) * (right - left + 1) / 2;
            if (curSum == sum) {
                ArrayList<Integer> list = new ArrayList<>();
                for (int i = left; i <= right; i++) {
                    list.add(i);
                }
                lists.add(list);
                left++;
            } else if (curSum < sum) {
                //如果当前窗口内的值之和小于sum，那么右边窗口右移一下
                right++;
            } else {
                left++;
            }
        }
        return lists;
    }
}
