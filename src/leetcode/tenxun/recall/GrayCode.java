package leetcode.tenxun.recall;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dengyouquan
 * @createTime 2019-01-26
 **/
public class GrayCode {
    public List<Integer> grayCode(int n) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < Math.pow(2, n); i++) {
            list.add((i >> 1) ^ i);
        }
        return list;
    }
}
