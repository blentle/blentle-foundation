package top.blentle.foundation.review.gc;

import java.io.Serializable;

/**
 * Created by blentle on 2017/2/13.
 */
public class GcFinalizeTest implements Serializable {
//    /**
//     * n是自然数
//     * 递归实现
//     * @param n
//     * @return
//     */
//    public static int fibonacci(int n) {
//        if (n == 0)
//            return 0;
//        if (n == 1 || n == 2)
//            return 1;
//        return fibonacci(n - 2) + fibonacci(n - 1);
//    }


    /**
     * n是自然数
     * 非递归实现
     *
     * @param n
     * @return
     */
    public static int fibonacci(int n) {
        if (n == 0)
            return 0;
        if (n == 1 || n == 2)
            return 1;
        int a, b;
        int sum = 0;
        a = b = 1;
        //这里从2开始遍历
        for (int i = 2; i < n; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.err.println(fibonacci(50));
    }
}
