package top.blentle.foundation.review.jdkapi.concurrent;

import java.util.concurrent.CountDownLatch;

/**
 * @author: blentle
 * @group: rd
 * @createdate: 2017/3/16 9:32
 * @mail: blentle.huan.ren@gmail.com
 * @description:
 * @since: 1.0
 */
public class Driver {
    public static void main(String[] args) throws InterruptedException {
        final int doneSize = 4;
        CountDownLatch startSignal = new CountDownLatch(1);
        CountDownLatch doneSignal = new CountDownLatch(doneSize);
        for(int i = 0; i < doneSize ; ++ i) {
            new Thread(new Worker(startSignal,doneSignal)).start();
            startSignal.countDown();

            doneSignal.await();
        }
    }
}
