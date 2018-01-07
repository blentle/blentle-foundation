package top.blentle.foundation.review.gc;

import java.io.Serializable;

/**
 * Created by blentle on 2017/2/13.
 */
public class GcFinalizeTest implements Serializable {

    private static final int mem = 1024 * 1024;

    public static void testAllocation() {
        byte[] allocation1, allocation2, allocation3, allocation4;
        allocation1 = new byte[2 * mem];
        allocation2 = new byte[2 * mem];
        allocation3 = new byte[2 * mem];
        allocation1 = new byte[4 * mem];
    }

    public static void main(String[] args) {
        testAllocation();
    }
}
