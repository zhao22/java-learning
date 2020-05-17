package src.mthreadpool;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 当队列里的任务数达到上限，并且池中正在运行的线程数小于maximumPoolSize，对于新加入的任务，新建线程。
 * 当任务4进入队列时发现队列的长度已经到了上限，所以无法进入队列排队，而此时正在运行的线程数（2）小于maximumPoolSize所以新建线程执行该任务。
 */
public class TestThreadPoolExecutor3 {

    public static void main(String[] args) {
        ThreadPoolExecutor pool = new ThreadPoolExecutor(2, 3, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue<>(1));
        // 任务1
        pool.execute(() -> {
            try {
                Thread.sleep(3 * 1000);
                System.out.println("-------------helloworld_001---------------" + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        // 任务2
        pool.execute(() -> {
            try {
                Thread.sleep(5 * 1000);
                System.out.println("-------------helloworld_002---------------" + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        // 任务3
        pool.execute(() -> {
            try {
                Thread.sleep(2 * 1000);
                System.out.println("-------------helloworld_003---------------" + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        // 任务4
        pool.execute(() -> {
            try {
                Thread.sleep(1 * 1000);
                System.out.println("-------------helloworld_004---------------" + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

    }

}