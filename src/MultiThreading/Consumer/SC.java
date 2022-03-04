package MultiThreading.Consumer;

import java.util.concurrent.Semaphore;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName SC
 * @Date 2021/7/29 16:12
 * @Version 1.0
 */


public class SC {
    static Semaphore full = new Semaphore(0); //代表缓冲资源
    static Semaphore empty = new Semaphore(10); //要生产10个资源

    //互斥操作资源
    static Semaphore mutex = new Semaphore(1);
    static int count = 0;

    static class Produce extends Thread{
        @Override
        public void run() {
            while(true){
                try{
                    Thread.sleep(100);
                    empty.acquire();
                    mutex.acquire();
                    count++;
                    System.out.println(Thread.currentThread().getName() + ": 生产第" + count + "个资源");

                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {

                    mutex.release();
                    full.release();
                }

            }
        }
    }


    static class Consumer extends Thread{
        @Override
        public void run() {
            while(true){
                try{
                    Thread.sleep(300);
                    full.acquire();
                    mutex.acquire();

                    System.out.println(Thread.currentThread().getName() + ": 消费了第" + count + "个资源");
                    count--;

                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {

                    mutex.release();
                    empty.release();
                }

            }
        }
    }


    public static void main(String[] args) {
        Thread t1 = new Produce();
        Thread t2 = new Produce();
        Thread t3 = new Produce();


        Thread t4 = new Consumer();
        Thread t5 = new Consumer();
        Thread t6 = new Consumer();
        Thread t7 = new Consumer();
        Thread t8 = new Consumer();

        t1.setName("生产者P1");
        t2.setName("生产者P2");
        t3.setName("生产者P3");
        t4.setName("消费者C1");
        t5.setName("消费者C2");
        t6.setName("消费者C3");
        t7.setName("消费者C4");
        t8.setName("消费者C5");


        t1.start();
        t2.start();
        //t3.start();
        t4.start();
        t5.start();
        t6.start();
        t7.start();
        t8.start();
    }

}
