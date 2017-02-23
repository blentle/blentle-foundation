package top.blentle.foundation.review.gc;

import java.io.Serializable;

/**
 * Created by blentle on 2017/2/13.
 */
public class GcFinalizeTest implements Serializable {
    public static void main(String[] args) {
        byte a = (byte)257;
        System.err.println(a);
    }
}
