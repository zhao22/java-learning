## 等待超时模式

对之前的等待 / 通知 范式做小改动，可以实现通知和超时都能完成返回。

```
// 对当前对象加锁
public synchronized Object get(long millis) throws InterruptedException {
    long future = System.currentTimeMillis() + millis;
    long remaining = millis;
    while ( (result == null) && remaining > 0) {
        wait(remaining);
        remaining = future - System.CurrentTimeMillis();
    }
    return result;
}
```

同样，此处手动加入remaining 的计算是为了防止wait被错误唤醒。