package MultiThreading.Print123455;

import java.util.concurrent.Semaphore;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName TwoThreadSemaphore
 * @Date 2021/7/28 21:39
 * @Version 1.0
 */


public class TwoThreadSemaphore {
    static Semaphore A = new Semaphore(1);
    static Semaphore B = new Semaphore(0);
    static volatile  int epoch = 0;

    static class ThreadA extends Thread{
        public void run(){
            int i = 1;
            while(epoch < 4){
                try {
                    A.acquire();
                    if(i <= 10 && epoch < 4)
                        System.out.println(Thread.currentThread().getName() + " : " + i);

                    B.release();
                    i = i + 2;
                    if(i > 10){
                        i = 1;

                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }


    static class ThreadB extends Thread{
        public void run(){
            int i = 2;
            while(epoch < 4){
                try {
                    B.acquire();
                    if(i <= 10 )
                        System.out.println(Thread.currentThread().getName() + " : " + i);
                    A.release();
                    i = i + 2;
                    if(i > 10){
                        i = 2;
                        epoch++;
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }

    public static void main(String[] args) {

            new ThreadA().start();
            new ThreadB().start();

    }
}
