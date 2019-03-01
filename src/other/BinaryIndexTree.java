package other;

import java.util.Objects;

/**
 * @author dengyouquan
 * @createTime 2019-02-27
 * 树状数组
 **/
public class BinaryIndexTree {
    //element[0]不存数据
    private int[] element;
    private int size;
    private static final int[] EMPTY_ARRAY = {};

    public BinaryIndexTree() {
        element = EMPTY_ARRAY;
        size = 0;
    }

    public BinaryIndexTree(int[] arr) {
        Objects.requireNonNull(arr);
        if (arr.length == 0) {
            element = EMPTY_ARRAY;
            size = 0;
        } else {
            element = new int[arr.length + 1];
            size = arr.length;
            build(arr);
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6};
        BinaryIndexTree tree = new BinaryIndexTree(arr);
        System.out.println(tree.sum(6));
    }

    public void build(int[] arr) {
        for (int i = 1; i <= size; i++) {
            element[i] = arr[i - 1];
            for (int j = i - 2; j >= i - lowBit(i); j--) {
                element[i] += arr[j];
            }
        }
    }

    public void add(int index, int increment) {
        checkIndex(index - 1);
        for (int i = index; i <= size; i += lowBit(i)) {
            element[i] += increment;
        }
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("index range error!");
        }
    }

    public int sum(int index) {
        checkIndex(index - 1);
        int res = 0;
        for (int i = index; i > 0; i -= lowBit(i)) {
            res += element[i];
        }
        return res;
    }

    public int lowBit(int n) {
        return n & -n;
    }
}
