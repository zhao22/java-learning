## Thread.join()

如果一个线程了 thread.join() 语句，其含义是: 当前线程 A 等待 thread 线程终止之后才从 thread.join 返回。
线程Thread除了提供 join() 方法之外，还提供了 join(long millis) 和 join(long millis, int nanos)两个具备超时特性的方法。
这两个超时方法表示，如果线程thread在给定的超时时间里没有终止，那么将会从该超时方法中返回。

测试Join类输出如下:
```
main terminate.
0 terminate. 
1 terminate. 
2 terminate. 
3 terminate. 
4 terminate. 
5 terminate. 
6 terminate. 
7 terminate. 
8 terminate. 
9 terminate. 
```

Thread中join的源码:
```
// 加锁当前线程对象
public final synchronized void join() throws InterruptedException() {
    // 条件不满足,继续等待
    while (isAlive()) {
        wait(0);
    }
    // 条件符合，方法返回
}
```

当线程终止时，会调用线程自身的notifyAll()方法，会通知所有等待在该线程对象上的线程。