package src.icountdownlatch;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest {

    private static CountDownLatch countDownLatch;
    private static CountDownLatch mainCountDownLatch;

    public static void main(String[] args) throws InterruptedException {
        int i = 10;
        countDownLatch = new CountDownLatch(i);
        mainCountDownLatch = new CountDownLatch(i);
        for (int j = 0; j < i; j++) {
            new Thread(CountDownLatchTest::run).start();
            Thread.sleep(100);
            countDownLatch.countDown();
        }
        try {
            mainCountDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void run()  {
        System.out.println(Thread.currentThread().getName() + "开始等待");
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "开始运行");
        mainCountDownLatch.countDown();
    }
}
