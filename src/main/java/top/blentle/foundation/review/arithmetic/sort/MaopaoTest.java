package top.blentle.foundation.review.arithmetic.sort;

import top.blentle.foundation.review.arithmetic.Data;

/**
 * @author :  renhuan
 * @email : blentle.huan.ren@gmail.com
 * @time :  2017/12/29 0029
 * @description :
 * @since : 1.0
 */
public class MaopaoTest extends Data {
    private static Integer[] data = getData().toArray(new Integer[getData().size()]);

    public static void sort() {
        System.err.println("sort before:");
        for(int number : data) {
            System.out.print(" " + number + " ");
        }
        System.out.println(" ");
        for(int i = 0 ; i < data.length - 1 ; i ++) {
            for(int j = data.length - 2; j > i ; j--) {
                if(data[j] < data[j+ 1]) {
                    int temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;
                }
            }
        }
        System.err.println("sort after:");
        for(int number : data) {
            System.out.print(" " + number + " ");
        }
    }


    public static void main(String[] args) {
        //sort();
        int f = Integer.highestOneBit((17 - 1) << 1);
        System.err.println(f);
    }
}
