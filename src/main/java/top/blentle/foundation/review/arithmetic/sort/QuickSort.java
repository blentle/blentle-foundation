package top.blentle.foundation.review.arithmetic.sort;

/**
 * @author: blentle
 * @group: rd  快速排序的实现
 * @createdate: 2017/3/18 14:41
 * @mail: blentle.huan.ren@gmail.com
 * @description: quick  sort
 * @since: 1.0
 */
public class QuickSort {
    private static Integer[] data = {12, 45, 458, 90, 87, 5789, 23, 45, 789, 13, 897, 33456, 405, 768, 907, 876, 100, 78, 333, 597, 980};

    public static void quickSort(Integer[] data, int l, int r) {
        int i = l;
        int j = r;
        int pvoit = data[(l + r) >> 1];
        while (i <= j) {
            while (data[i] < pvoit) {
                i++;
            }
            while (data[j] > pvoit) {
                j--;
            }
            if (i <= j) {
                int temp = data[i];
                data[i] = data[j];
                data[j] = temp;
                i++;
                j--;
            }
        }
        if (l < j)
            quickSort(data, l, j);
        if (i < r)
            quickSort(data, i, r);

    }

    public static void main(String[] args) {
        for (int number : data) {
            System.out.print(" " + number);
        }
        System.out.print("\r\n");
        quickSort(data, 0, data.length - 1);
        for (int number : data) {
            System.out.print(" " + number);
        }
        System.out.print("\r\n");
    }
}
