package MultiThreading.Consumer;

import java.util.concurrent.Semaphore;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName SemaphoreConsumer
 * @Date 2021/7/29 15:38
 * @Version 1.0
 */


public class SemaphoreConsumer {
    Semaphore full = new Semaphore(0); //代表缓冲资源
    Semaphore empty = new Semaphore(10); //要生产10个资源

    //互斥操作资源
    Semaphore mutex = new Semaphore(1);

    static int count = 0;

    public void produce() throws InterruptedException {
        while(true){
            Thread.sleep(100);
            try {
                empty.acquire();
                mutex.acquire();
                count++;
                System.out.println(Thread.currentThread().getName() + ": 生产第" + count + "个资源");
            } finally {
                mutex.release();
                full.release();
            }

        }
    }

    public void consumer() throws InterruptedException {
        while(true){
            Thread.sleep(200);
            try {
                full.acquire();
                mutex.acquire();
                System.out.println(Thread.currentThread().getName() + ": 消费第" + count + "个资源");
                count--;
            }finally {
                mutex.release();
                empty.release();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        SemaphoreConsumer sc = new SemaphoreConsumer();
        Thread t1 = new Thread(()->{
            try {
                sc.produce();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "生产者P1");

        Thread t2 = new Thread(()->{
            try {
                sc.produce();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "生产者P2");

        Thread t3 = new Thread(()->{
            try {
                sc.produce();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "生产者P3");



        Thread t4 = new Thread(()->{
            try {
                sc.consumer();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "消费者C1");

        Thread t5 = new Thread(()->{
            try {
                sc.consumer();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "消费者C2");

        Thread t6 = new Thread(()->{
            try {
                sc.consumer();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "消费者C3");

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
    }
}
