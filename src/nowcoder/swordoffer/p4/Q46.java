package nowcoder.swordoffer.p4;

import java.util.LinkedList;
import java.util.List;

/**
 * @author dengyouquan
 * @createTime 2019-02-08
 **/
public class Q46 {
    public static void main(String[] args) {

    }

    public int LastRemaining_Solution(int n, int m) {
        if (n <= 0 || m <= 0) return -1;
        int sum = 0;
        for (int i = 2; i <= n; i++) {
            sum = (sum + m) % i;
        }
        return sum;
    }

    public int LastRemaining_Solution2(int n, int m) {
        if (n <= 0 || m <= 0) return -1;
        //删除效率
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        int index = 0;
        while (list.size() > 1) {
            index = (index + m - 1) % list.size();
            list.remove(index);
        }
        return list.get(0);
    }
}
