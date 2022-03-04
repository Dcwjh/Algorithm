package MultiThreading;

import java.util.concurrent.Semaphore;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName PrintABC4
 * @Date 2021/7/29 0:24
 * @Version 1.0
 */


public class PrintABC4 {
    private static Semaphore A = new Semaphore(1);
    private static Semaphore B = new Semaphore(0);
    private static Semaphore C = new Semaphore(0);

    static class printA extends Thread{

        @Override
        public void run() {
            for(int i = 0; i < 10; i++){
                try {
                    A.acquire();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.print("A");

                B.release();
            }
        }
    }


    static class printB extends Thread{

        @Override
        public void run() {
            for(int i = 0; i < 10; i++){
                try {
                    B.acquire();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.print("B");

                C.release();
            }
        }
    }

    static class printC extends Thread{

        @Override
        public void run() {
            for(int i = 0; i < 10;i++){
                try {
                    C.acquire();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.print("C");

                A.release();
            }
        }
    }

    public static void main(String[] args) {
        new printA().start();
        new printB().start();
        new printC().start();
    }
}
