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

    public static void sort(Integer[] data, int leftIndex, int rightIndex) {
        if (leftIndex >= rightIndex)
            return;
        int midIndex = (leftIndex + rightIndex) >>> 1;
        sort(data,leftIndex ,midIndex);
        sort(data,midIndex + 1, rightIndex);
        merge(data,leftIndex,midIndex,rightIndex);
    }

    private static void merge(Integer[] data, int leftIndex, int midIndex, int rightIndex) {
        int[] tmp = new int[data.length];
        int r1 = midIndex + 1;
        int left = leftIndex;
        int cIndex = leftIndex;
        while(leftIndex <= midIndex && r1 <= rightIndex) {
            if(data[leftIndex] <= data[r1])
                tmp[left ++] = data[leftIndex ++];
            else
                tmp[left ++] = data[r1 ++];
        }
        while(leftIndex <= midIndex)
            tmp[left ++] = data[leftIndex ++];
        while(r1 <= rightIndex)
            tmp[left ++] = data[r1 ++];

        while(cIndex <= rightIndex) {
            data[cIndex]=tmp[cIndex];
            cIndex ++;
        }
    }


    public static void main(String[] args) {
        sort(data, 0, data.length - 1);
        System.err.println("sort after:");
        for(int number : data) {
            System.out.print(" " + number + " ");
        }
    }
}
