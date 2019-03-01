package nowcoder.swordoffer.p2;

/**
 * @author dengyouquan
 * @createTime 2019-02-06
 **/
public class Q23 {
    public static void main(String[] args) {
        System.out.println(new Q23().VerifySquenceOfBST(new int[]{4, 6, 12, 16, 14, 10}));
    }

    public boolean VerifySquenceOfBST(int[] sequence) {
        int len;
        if (sequence == null || (len = sequence.length) == 0) return false;
        return judge(sequence, 0, len - 1);
    }

    /*
    BST的后序序列的合法序列是，对于一个序列S，最后一个元素是x （也就是根），如果去掉最后一个元素的序列为T，那么T满足：T可以分成两段，前一段（左子树）小于x，后一段（右子树）大于x，且这两段（子树）都是合法的后序序列。完美的递归定义 : )
     */
    private boolean judge(int[] sequence, int left, int right) {
        if (left >= right) return true;
        int root = sequence[right];
        int l = left, r = right - 1;
        while (l <= right && sequence[l] < root) l++;
        while (r >= l) {
            if (root > sequence[r]) return false;
            r--;
        }
        //不判断right，right是root的值
        return judge(sequence, left, l - 1) && judge(sequence, l, right - 1);
    }
}
