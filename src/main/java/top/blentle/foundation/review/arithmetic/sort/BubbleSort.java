package top.blentle.foundation.review.arithmetic.sort;

/**
 * @author: blentle
 * @group: rd
 * @createdate: 2017/3/17 9:12
 * @mail: blentle.huan.ren@gmail.com
 * @description:
 * @since: 1.0
 */
public class BubbleSort extends Data {

    private static Integer[] data = getData().toArray(new Integer[getData().size()]);

    public static void sort() {
        System.err.println("sort before:");
        for(int number : data) {
            System.out.print(" " + number + " ");
        }
        for(int i = data.length - 1 ; i > 0 ; i --) {
            for(int j = 0 ; j < i ; j ++) {
                if(data[j] > data[j + 1]) {
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
        sort();
    }
}
