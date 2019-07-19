package com.sundy.ch01;

/**
 * @desc:
 * @author: liuguozhu
 * @date: 2019/7/19
 * @version: v1.0
 */
public class Test {
    private long count = 0;

    private void add10K() {
        int idx = 0;
        while (idx++ < 100000000) {
            count += 1;
        }
        System.out.println("count=" + count);
    }

    public long calc() throws InterruptedException {
        // 创建两个线程，执行add()操作
        Thread th1 = new Thread(() -> {
            this.add10K();
            System.out.println("thread1 running ");
        });
        Thread th2 = new Thread(() -> {
            this.add10K();
            System.out.println("thread2 running ");
        });
        //启动两个线程
        th1.start();
        th2.start();
        // 等待两个线程执行结束
        th1.join();
        th2.join();
        System.out.println("count=" + count);
        return count;
    }

    public static void main(String[] args) throws InterruptedException {
        //long count = Test.calc();
        Test test = new Test();
        long count = test.calc();
        System.out.println(count);
    }

}
