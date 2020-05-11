package src.hreentrantlock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest3 {

    static Lock lock1 = new ReentrantLock();
    static Lock lock2 = new ReentrantLock();

    public static void main(String[] args){
        Thread thread = new Thread(new ThreadDemo(lock1, lock2));
        Thread thread1 = new Thread(new ThreadDemo(lock2, lock1));
        thread.start();
        thread1.start();
    }

    static class ThreadDemo implements Runnable {

        Lock firstLock;
        Lock secondLock;
        public ThreadDemo(Lock firstLock, Lock secondLock) {
            this.firstLock = firstLock;
            this.secondLock = secondLock;
        }

        @Override
        public void run() {
            try {
                firstLock.tryLock(10, TimeUnit.MILLISECONDS);
                secondLock.tryLock(10, TimeUnit.MILLISECONDS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                firstLock.unlock();
                secondLock.unlock();
                System.out.println(Thread.currentThread().getName() + "获取到了资源，正常结束");
            }
        }
    }
}
