package top.blentle.foundation.review.arithmetic.sort;

/**
 * @author :  renhuan
 * @email : blentle.huan.ren@gmail.com
 * @time :  2017/12/29 0029
 * @description :
 * @since : 1.0
 */
public class QuickSortTest extends Data {

    private static int[] target = new int[]{12, 45, 458, 90, 87, 5789, 23, 45, 789, 13, 897, 33456, 405, 768, 907, 876, 90, 100, 78, 333, 597, 980};

    public static void main(String[] args) {
        quickSort(target, 0, target.length - 1);
        for (Integer s : target) {
            System.err.print(s + " ");
        }
    }

    private static void quickSort(int[] data, int leftIndex, int rightIndex) {
        int pvoit = data[((leftIndex + rightIndex) >> 1)];
        int i = leftIndex;
        int j = rightIndex;
        while (i <= j) {
            while (data[i] < pvoit)
                i++;
            while (data[j] > pvoit)
                j--;
            if (i <= j) {
                int temp = data[i];
                data[i] = data[j];
                data[j] = temp;
                i++;
                j--;
            }
        }
        if (j >= leftIndex)
            quickSort(data, leftIndex, j);
        if (i <= rightIndex)
            quickSort(data, i, rightIndex);
    }
}
