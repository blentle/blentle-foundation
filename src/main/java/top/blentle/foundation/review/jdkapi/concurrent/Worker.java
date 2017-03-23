package top.blentle.foundation.review.jdkapi.concurrent;

import java.util.concurrent.CountDownLatch;

/**
 * @author: blentle
 * @group: rd
 * @createdate: 2017/3/16 16:58
 * @mail: blentle.huan.ren@gmail.com
 * @description:
 * @since: 1.0
 */
public class Worker implements Runnable{
    private CountDownLatch startThread;
    private CountDownLatch doneThread;

    public Worker(CountDownLatch startThread, CountDownLatch doneThread) {
        this.startThread = startThread;
        this.doneThread = doneThread;
    }

    public void run() {
        try {
            startThread.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        doWork();
        doneThread.countDown();
    }

    private void doWork() {
        System.err.println("execute task....");
    }
}
