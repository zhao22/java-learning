package src.hreentrantlock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest1 {

    private static final ReentrantLock fairLock = new ReentrantLock(true);

    private static final ReentrantLock unfairLock = new ReentrantLock(false);

    public static void main(String[] args) throws InterruptedException {
        new Thread(ReentrantLockTest1::testFair, "线程A").start();
        new Thread(ReentrantLockTest1::testFair, "线程B").start();
        new Thread(ReentrantLockTest1::testFair, "线程C").start();
        Thread last = new Thread(ReentrantLockTest1::testFair, "线程D");
        last.start();
        last.join();
        new Thread(ReentrantLockTest1::testUnFair, "线程E").start();
        new Thread(ReentrantLockTest1::testUnFair, "线程F").start();
        new Thread(ReentrantLockTest1::testUnFair, "线程G").start();
        new Thread(ReentrantLockTest1::testUnFair, "线程H").start();
    }

    public static void testFair() {
        for (int i = 0; i < 2; i++) {
            try {
                fairLock.lock();
                System.out.println(Thread.currentThread().getName() + "获取了公平锁");
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                fairLock.unlock();
            }
        }
    }

    public static void testUnFair() {
        for (int i = 0; i < 2; i++) {
            try {
                unfairLock.lock();
                System.out.println(Thread.currentThread().getName() + "获取了非公平锁");
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                unfairLock.unlock();
            }
        }
    }
}
