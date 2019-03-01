package leetcode.tenxun.recall;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dengyouquan
 * @createTime 2019-01-26
 **/
public class GenerateParenthesis {
    public static void main(String[] args) {
        System.out.println(new GenerateParenthesis().generateParenthesis(3));
    }

    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        dfs("", list, n, n);
        return list;
    }

    public static void dfs(String s, List<String> list, int left, int right) {
        //剪枝
        if (left > right) return;
        if (left > 0) {
            dfs(s + "(", list, left - 1, right);
        }
        if (right > 0) {
            dfs(s + ")", list, left, right - 1);
        }
        if (left == 0 && right == 0) {
            list.add(s);
        }
    }
}
