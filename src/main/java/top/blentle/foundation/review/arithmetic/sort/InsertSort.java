package top.blentle.foundation.review.arithmetic.sort;

/**
 * @author: blentle
 * @group: rd
 * @createdate: 2017/3/18 14:23
 * @mail: blentle.huan.ren@gmail.com
 * @description: insert sort
 * @since: 1.0
 */
public class InsertSort extends Data {
    private static Integer[] data = getData().toArray(new Integer[getData().size()]);

    public static void sort() {
        for(int i = 0 ; i < data.length ; i++) {
            int j = i;
            int base = data[i];
            while(j > 0 && data[j - 1] > base) {
                data[j] = data[j -1];
                j--;
            }
            data[j] = base;
        }
        System.err.println("sort after:");
        for(int d : data) {
            System.out.print(d + " ");
        }

    }

    public static void main(String[] args) {
        sort();
    }
}
