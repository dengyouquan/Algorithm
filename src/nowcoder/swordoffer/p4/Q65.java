package nowcoder.swordoffer.p4;

/**
 * @author dengyouquan
 * @createTime 2019-02-08
 **/
public class Q65 {
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        boolean[] visited = new boolean[matrix.length];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (helper(matrix, rows, cols, i, j, 0, str, visited)) return true;
            }
        }
        return false;
    }

    private boolean helper(char[] matrix, int rows, int cols, int r, int c, int index, char[] str, boolean[] visited) {
        if (r < 0 || r >= rows || c < 0 || c >= cols || matrix[r * cols + c] != str[index] || visited[r * cols + c])
            return false;
        if (index == str.length - 1) return true;
        visited[r * cols + c] = true;
        if (helper(matrix, rows, cols, r + 1, c, index + 1, str, visited)
                || helper(matrix, rows, cols, r - 1, c, index + 1, str, visited)
                || helper(matrix, rows, cols, r, c + 1, index + 1, str, visited)
                || helper(matrix, rows, cols, r, c - 1, index + 1, str, visited)) return true;
        visited[r * cols + c] = false;
        return false;
    }
}
