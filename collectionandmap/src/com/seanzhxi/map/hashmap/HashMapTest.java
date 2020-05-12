package com.seanzhxi.map.hashmap;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;

public class HashMapTest {

    public static void main(String[] args) throws InterruptedException {
//        Map<String, Object> map = new HashMap<>();
        Map<String, Object> map = new ConcurrentHashMap<>();
        CountDownLatch countDownLatch = new CountDownLatch(2);
        new Thread(() -> {
            for (int i = 0; i < 2000; i++) {
                map.put("keyA" + i,  "something");
            }
            countDownLatch.countDown();
        }).start();
        new Thread(() -> {
            for (int i = 0; i < 2000; i++) {
                map.put("keyB" + i,  "something");
            }
            countDownLatch.countDown();
        }).start();
        countDownLatch.await();
        System.out.println(map.size());
    }
}
