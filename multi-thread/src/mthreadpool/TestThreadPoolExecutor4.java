package src.mthreadpool;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 当队列里的任务数达到上限，并且池中正在运行的线程数等于maximumPoolSize，对于新加入的任务，执行拒绝策略（线程池默认的拒绝策略是抛异常）。
 * 当任务5加入时，队列达到上限，池内运行的线程数达到最大，故执行默认的拒绝策略，抛异常。
 */
public class TestThreadPoolExecutor4 {

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
        pool.execute(() -> System.out.println("-------------helloworld_003---------------" + Thread.currentThread().getName()));

        // 任务4
        pool.execute(() -> {
            try {
                Thread.sleep(2 * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("-------------helloworld_004---------------" + Thread.currentThread().getName());
        });

        // 任务5
        pool.execute(() -> System.out.println("-------------helloworld_005---------------" + Thread.currentThread().getName()));

    }

}