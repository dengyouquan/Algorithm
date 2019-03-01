package nowcoder.swordoffer.p4;

/**
 * @author dengyouquan
 * @createTime 2019-02-08
 **/
public class Q66 {
    public int movingCount(int threshold, int rows, int cols) {
        boolean[] visited = new boolean[rows * cols];
        return movingCountCore(threshold, rows, cols, 0, 0, visited);
    }

    private int movingCountCore(int threshold, int rows, int cols, int r, int c, boolean[] visited) {
        if (r < 0 || r >= rows || c < 0 || c >= cols) return 0;
        int i = r * cols + c;
        if (visited[i] || !checkSum(threshold, r, c)) return 0;
        visited[i] = true;
        return 1 + movingCountCore(threshold, rows, cols, r + 1, c, visited)
                + movingCountCore(threshold, rows, cols, r - 1, c, visited)
                + movingCountCore(threshold, rows, cols, r, c + 1, visited)
                + movingCountCore(threshold, rows, cols, r, c - 1, visited);

    }

    private boolean checkSum(int threshold, int r, int c) {
        int sum = 0;
        while (r != 0) {
            sum += r % 10;
            r /= 10;
        }
        while (c != 0) {
            sum += c % 10;
            c /= 10;
        }
        if (sum > threshold) return false;
        return true;
    }
}
