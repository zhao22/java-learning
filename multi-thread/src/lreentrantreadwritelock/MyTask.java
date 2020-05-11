package src.lreentrantreadwritelock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class MyTask {

    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    
    public void read() {
        try {
            lock.readLock().lock();
            System.out.println(Thread.currentThread().getName() + " start");
            Thread.sleep(10000);
            System.out.println(Thread.currentThread().getName() + " end");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.readLock().unlock();
        }
    }

    public void write() {
        try {
            lock.writeLock().lock();
            System.out.println(Thread.currentThread().getName() + " start");
            Thread.sleep(3000);
            System.out.println(Thread.currentThread().getName() + " end");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.writeLock().unlock();
        }
    }

    /**
     * 读读共享
     */
    static class ReadReadTest {

        public static void main(String[] args) {
            final MyTask myTask = new MyTask();

            Thread t1 = new Thread(myTask::read);
            t1.setName("read1");

            Thread t2 = new Thread(myTask::read);
            t2.setName("read2");

            t1.start();
            t2.start();
        }
    }

    /**
     * 写写互斥
     */
    static class WriteWriteTest {

        public static void main(String[] args) {
            final MyTask myTask = new MyTask();

            Thread t1 = new Thread(myTask::write);
            t1.setName("write1");

            Thread t2 = new Thread(myTask::write);
            t2.setName("write2");

            t1.start();
            t2.start();
        }
    }

    /**
     * 写读互斥
     */
    static class WriteReadTest {

        public static void main(String[] args) {
            final MyTask myTask = new MyTask();

            Thread t1 = new Thread(myTask::write);
            t1.setName("write");

            Thread t2 = new Thread(myTask::read);
            t2.setName("read");

            t1.start();
            t2.start();
        }
    }

    /**
     * 读写互斥
     */
    static class ReadWriteTest {

        public static void main(String[] args) {
            final MyTask myTask = new MyTask();

            Thread t1 = new Thread(myTask::read);
            t1.setName("read");

            Thread t2 = new Thread(myTask::write);
            t2.setName("write");

            t1.start();
            t2.start();
        }
    }
}