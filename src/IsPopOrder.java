import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author dengyouquan
 * @createTime 2019-01-23
 **/
public class IsPopOrder {
    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 3, 4, 5};
        int[] b = new int[]{4, 5, 3, 2, 1};
        int[] c = new int[]{4, 3, 5, 1, 2};
        System.out.println(new IsPopOrder().IsPopOrder(a, c));
    }

    public boolean IsPopOrder(int[] pushA, int[] popA) {
        int index = 0;
        List<Integer> push = new ArrayList<>();
        List<Integer> pop = new ArrayList<>();
        for (int i = 0; i < pushA.length; i++) {
            push.add(pushA[i]);
        }
        for (int i = 0; i < popA.length; i++) {
            pop.add(popA[i]);
        }
        while (index < push.size() && index > -1) {
            while (index < push.size() && push.get(index) != pop.get(0)) {
                index++;
            }
            if (index >= push.size()) return false;
            if (index >= 0 && push.get(index) == pop.get(0)) {
                push.remove(index);
                index--;
                pop.remove(0);
            }
        }
        if (pop.isEmpty()) return true;
        return false;
    }
}
