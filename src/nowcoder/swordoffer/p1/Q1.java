package nowcoder.swordoffer.p1;

/**
 * @author dengyouquan
 * @createTime 2019-02-05
 **/
public class Q1 {
    public static void main(String[] args) {
        int[][] nums = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(new Q1().Find(1432, nums));
    }

    public boolean Find(int target, int[][] array) {
        int rows = array.length;
        int columns = array[0].length;
        int x = 0;
        int y = rows - 1;
        while (x < columns && y >= 0) {
            if (target == array[x][y]) {
                return true;
            } else if (target < array[x][y]) {
                y--;
            } else {
                x++;
            }
        }
        return false;
    }
}
