package MultiThreading.Print123455;

import java.util.concurrent.Semaphore;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName Semaphore
 * @Date 2021/7/28 21:12
 * @Version 1.0
 */


public class ThreeThreadSemaphoreMethod {
    private static Semaphore A = new Semaphore(1);
    private static Semaphore B = new Semaphore(0);
    private static Semaphore C = new Semaphore(0);
    static volatile int num = 1;
    static volatile int epcho = 0;

    static class ThreadA extends Thread {
        public void run() {
            while (num <= 10 && epcho < 4)
                try {
                    A.acquire();
                    //打印判断
                    if (num <= 10 && epcho < 4) {
                        System.out.println(Thread.currentThread().getName() + ": " + num);
                    }
                    //变量赋值
                    if (num < 10) {
                        num++;
                    } else { //循环打印
                        num = 1;
                        epcho++;
                    }
                    B.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
        }


    }


    static class ThreadB extends Thread {
        public void run() {
            while (num <= 10 && epcho < 4)
                try {
                    B.acquire();
                    if (num <= 10 && epcho < 4) {
                        System.out.println(Thread.currentThread().getName() + ": " + num);
                    }
                    if (num < 10) {
                        num++;
                    } else {
                        num = 1;
                        epcho++;
                    }

                    C.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
        }


    }


    static class ThreadC extends Thread {
        public void run() {
            while (num <= 10 && epcho < 4)
                try {
                    C.acquire();
                    if (num <= 10 && epcho < 4) {
                        System.out.println(Thread.currentThread().getName() + ": " + num);
                    }
                    if (num < 10) {
                        num++;
                    } else {
                        num = 1;
                        epcho++;
                    }
                    A.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
        }


    }

    public static void main(String[] args) {
        new ThreadA().start();
        new ThreadB().start();
        new ThreadC().start();
    }
}
