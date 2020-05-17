package src.mthreadpool;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class TestThreadPoolExecutor1 {

    /**
     * 当池中正在运行的线程数（包括空闲线程）小于corePoolSize时，新建线程执行任务。
     * 当执行任务1的线程（thread-1）执行完成之后，任务2并没有去复用thread-1而是新建线程（thread-2）去执行任务。
     * @param args
     */
    public static void main(String[] args) {
        ThreadPoolExecutor pool = new ThreadPoolExecutor(2, 3, 60L, TimeUnit.SECONDS,new LinkedBlockingQueue<>(1));
        //任务1
        pool.execute(() -> System.out.println("-------------helloworld_001---------------" + Thread.currentThread().getName()));
        
        try {
            //主线程睡2秒
            Thread.sleep(2*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //任务2
        pool.execute(() -> System.out.println("-------------helloworld_002---------------" + Thread.currentThread().getName()));
    }

}