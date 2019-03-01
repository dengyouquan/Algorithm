package nowcoder.swordoffer.p3;

/**
 * @author dengyouquan
 * @createTime 2019-02-07
 **/
public class Q35 {
    public static void main(String[] args) {
        int[] array = new int[]{364, 637, 341, 406, 747, 995, 234, 971, 571, 219, 993, 407, 416, 366, 315, 301, 601, 650, 418, 355, 460, 505, 360, 965, 516, 648, 727, 667, 465, 849, 455, 181, 486, 149, 588, 233, 144, 174, 557, 67, 746, 550, 474, 162, 268, 142, 463, 221, 882, 576, 604, 739, 288, 569, 256, 936, 275, 401, 497, 82, 935, 983, 583, 523, 697, 478, 147, 795, 380, 973, 958, 115, 773, 870, 259, 655, 446, 863, 735, 784, 3, 671, 433, 630, 425, 930, 64, 266, 235, 187, 284, 665, 874, 80, 45, 848, 38, 811, 267, 575};
        System.out.println(new Q35().InversePairs(array));
    }

    private int count = 0;

    public int InversePairs(int[] array) {
        int len;
        if (array == null || (len = array.length) == 0) return 0;
        partition(array, 0, len - 1);
        return count;
    }

    private void partition(int[] array, int start, int end) {
        if (start >= end) return;
        int mid = start + ((end - start) >> 1);
        partition(array, start, mid);
        partition(array, mid + 1, end);
        merge(array, start, mid, end);
    }

    /*
    归并排序的改进，把数据分成前后两个数组(递归分到每个数组仅有一个数据项)，
合并数组，合并时，出现前面的数组值array[i]大于后面数组值array[j]时；则前面
数组array[i]~array[mid]都是大于array[j]的，count += mid+1 - i
     */
    private void merge(int[] array, int start, int mid, int end) {
        int[] newArr = new int[end - start + 1];
        int left = start;
        int right = mid + 1;
        int index = 0;
        while (left <= mid && right <= end) {
            if (array[left] < array[right]) {
                newArr[index++] = array[left++];
            } else {
                newArr[index++] = array[right++];
                count += mid - left + 1;
                count %= 1000000007;
            }
        }
        while (left <= mid) {
            newArr[index++] = array[left++];
        }
        while (right <= end) {
            newArr[index++] = array[right++];
        }
        for (int i = 0; i < newArr.length; i++) {
            array[start + i] = newArr[i];
        }
    }
}
