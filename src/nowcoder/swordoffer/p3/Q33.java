package nowcoder.swordoffer.p3;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dengyouquan
 * @createTime 2019-02-07
 **/
public class Q33 {
    public int GetUglyNumber_Solution(int index) {
        List<Integer> list = new ArrayList<>();
        if (index < 7) return index;
        int p2 = 0, p3 = 0, p5 = 0;
        list.add(1);
        for (int i = 1; i < index; i++) {
            list.add(Math.min(list.get(p2) * 2, Math.min(list.get(p3) * 3, list.get(p5) * 5)));
            if (list.get(i) == list.get(p2) * 2) p2++;
            if (list.get(i) == list.get(p3) * 3) p3++;
            if (list.get(i) == list.get(p5) * 5) p5++;
        }
        return list.get(index - 1);
    }
}
