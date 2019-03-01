package other;

import java.util.Arrays;
import java.util.Random;

/**
 * @author dengyouquan
 **/
public class Shuffle {
    public static Random random = new Random();

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6};
        System.out.println("Flasher Yates Shuffle:" + Arrays.toString(FYShuffle(arr.clone())));
        int[] arr1 = new int[]{1, 2, 3, 4, 5, 6};
        KDShuffle(arr1);
        System.out.println("Knuth-Durstenfeld Shuffle:" + Arrays.toString(arr1));
        System.out.println("Inside-Out Algorithm:" + Arrays.toString(IOShuffle(arr.clone())));
    }

    public static int[] FYShuffle(int[] arr) {
        int len;
        if (arr == null || (len = arr.length) == 0) return arr;
        int[] newArr = new int[len];
        int index = 0;
        while (len > 0) {
            int i = random.nextInt(len--);
            //put new array
            newArr[index++] = arr[i];
            //remove array data
            arr[i] = arr[len];
        }
        return newArr;
    }

    public static void KDShuffle(int[] arr) {
        int len;
        if (arr == null || (len = arr.length) == 0) return;
        //长度只有1时不交换
        while (len > 0) {
            //先得到index在--len
            int index = random.nextInt(len);
            swap(arr, index, --len);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        if (i == j) return;
        arr[i] ^= arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] ^= arr[j];
    }

    public static int[] IOShuffle(int[] arr) {
        int len;
        if (arr == null || (len = arr.length) == 0) return arr;
        int[] newArr = arr.clone();
        for (int i = 1; i < len; i++) {
            int index = random.nextInt(i);
            newArr[i] = newArr[index];
            newArr[index] = arr[i];
        }
        return newArr;
    }
}
