package sort;

/**
 * @author dengyouquan
 **/
public class HeapSort {
    public static void main(String[] args) {
        new HeapSort().heapSort(null);
    }

    public void heapSort(int[] arr) {
        int len;
        if (arr == null || (len = arr.length) == 0) return;
        //构建大顶堆
        buildHeap(arr, len);
        for (int i = len - 1; i > 0; i--) {
            swap(arr, 0, i);
            //对0-i之间进行堆调整
            adjustHeap(arr, 0, i);
        }
    }

    private void swap(int[] arr, int i, int j) {
        arr[i] ^= arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] ^= arr[j];
    }

    //O(n)
    private void buildHeap(int[] arr, int len) {
        for (int i = len / 2 - 1; i >= 0; i--) {
            adjustHeap(arr, i, len);
        }
    }

    //O(nlogn)
    //对start-end之间进行堆调整
    private void adjustHeap(int[] arr, int start, int end) {
        int temp = arr[start];
        for (int i = 2 * start + 1; i < end; i = 2 * i + 1) {
            if (i + 1 < end && arr[i] < arr[i + 1]) {
                i++;
            }
            if (arr[i] > temp) {
                arr[start] = arr[i];
                start = i;
            } else {
                break;
            }
        }
        arr[start] = temp;
    }
}
