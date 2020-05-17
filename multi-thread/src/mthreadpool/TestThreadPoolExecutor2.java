package src.mthreadpool;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 当池中正在运行的线程数大于等于corePoolSize时，新插入的任务进入workQueue排队（如果workQueue长度允许），等待空闲线程来执行。
 * 任务3会等待任务1执行完之后，有了空闲线程，才会执行。并没有新建线程执行任务3，这时maximumPoolSize=3这个参数不起作用
 */
public class TestThreadPoolExecutor2 {

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

    }

}