package nowcoder.swordoffer.p2;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author dengyouquan
 * @createTime 2019-02-06
 **/
public class Q21 {
    public static void main(String[] args) {
        int[] pushA = new int[]{1, 2, 3, 4, 5};
        int[] popA = new int[]{4, 3, 5, 1, 2};
        System.out.println(new Q21().IsPopOrder(pushA, popA));
    }

    public boolean IsPopOrder(int[] pushA, int[] popA) {
        if (pushA.length == 0) return false;
        Deque<Integer> stackA = new ArrayDeque<>();
        int indexA = 1, indexB = 0;
        stackA.push(pushA[0]);
        while (indexB < popA.length) {
            if (stackA.peek() == popA[indexB]) {
                stackA.pop();
                indexB++;
            } else {
                if (indexA == pushA.length) return false;
                stackA.push(pushA[indexA++]);
            }
        }
        if (stackA.isEmpty()) return true;
        return false;
    }
}
