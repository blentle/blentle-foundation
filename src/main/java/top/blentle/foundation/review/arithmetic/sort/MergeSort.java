package top.blentle.foundation.review.arithmetic.sort;

import top.blentle.foundation.review.arithmetic.Data;

/**
 * @author: blentle
 * @group: rd
 * @createdate: 2017/3/18 14:41
 * @mail: blentle.huan.ren@gmail.com
 * @description: merge sort
 * @since: 1.0
 */
public class MergeSort extends Data {

    private static Integer[] data = getData().toArray(new Integer[getData().size()]);

    public static void sort() {
        //todo : divide data into two segments ...
        System.err.println("sort after:");
        for (int number : data) {
            System.out.print(" " + number + " ");
        }
    }

    public static void main(String[] args) {
        sort();
    }
}
