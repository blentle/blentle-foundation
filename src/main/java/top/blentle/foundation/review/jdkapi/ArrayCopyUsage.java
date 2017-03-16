package top.blentle.foundation.review.jdkapi;

/**
 * @author: blentle
 * @group: rd
 * @createdate: 2017/2/23 10:14
 * @mail: blentle.huan.ren@gmail.com
 * @description: show the usage of System.arrycopy();
 * @since: 1.0
 */
public class ArrayCopyUsage {
    /**
     * cover existed position
     */
    public static void main(String[] args) {
        String[] a = {"1", "2", "3", "4"};
        String[] b = {"5", "6", "7"};
        System.arraycopy(a, 2, b, 0, a.length - 2);
        for (String s : b) {
            System.err.println(s);
        }
    }
}
