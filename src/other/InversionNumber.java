package other;

/**
 * @author dengyouquan
 * @createTime 2019-02-27
 **/
public class InversionNumber {
    private static int count = 0;

    public static void main(String[] args) {
        //8
        int[] arr = new int[]{2, 6, 3, 4, 5, 1};
        getInversionNumber(arr);
        System.out.println(count);
    }

    private static void getInversionNumber(int[] arr) {
        if (arr == null || arr.length == 0) return;
        sortAndCalc(arr, 0, arr.length - 1);
    }

    private static void sortAndCalc(int[] arr, int left, int right) {
        if (left >= right) return;
        int mid = left + ((right - left) >> 1);
        sortAndCalc(arr, left, mid);
        sortAndCalc(arr, mid + 1, right);
        mergeAndCalc(arr, left, mid, right);
    }

    private static void mergeAndCalc(int[] arr, int left, int mid, int right) {
        int l = left, r = mid, k = 0;
        int[] newArr = new int[right - left + 1];
        while (l <= mid && r <= right) {
            if (arr[l] <= arr[r]) {
                newArr[k++] = arr[l++];
            } else {
                newArr[k++] = arr[r++];
                /* 因为此时arr[l...mid]已经排序，如果arr[l] 与 arr[r] 逆序,
            则arr[l+1], arr[l+2]...arr[mid] 都与arr[k]逆序, 共 mid-l+1 对*/
                count = count + (mid - l + 1);
            }
        }
    }
}
