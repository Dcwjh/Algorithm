package MultiThreading;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName PrintABCTest
 * @Date 2021/7/29 14:10
 * @Version 1.0
 */


public class PrintABCTest {
    static Object monitor = new Object();
    static String id = "A";


    static class PrintA extends Thread{

        @Override
        public void run() {
            for(int i = 0; i < 10; )
                synchronized (monitor){
                    while(!id.equals("A")) {
                        try {
                            monitor.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println(Thread.currentThread().getName() + ": A");
                    id = "B";
                    i++;
                    monitor.notifyAll();
                }
        }
    }


    static class PrintB extends Thread{
        @Override
        public void run() {
            for(int i = 0; i < 10; )
                synchronized (monitor){
                    while(!id.equals("B")) {
                        try {
                            monitor.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println(Thread.currentThread().getName() + ": B");
                    id = "C";
                    i++;
                    monitor.notifyAll();
                }
        }
    }

    static class PrintC extends Thread{
        @Override
        public void run() {
            for(int i = 0; i < 10; )
                synchronized (monitor){
                    while(!id.equals("C")) {
                        try {
                            monitor.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println(Thread.currentThread().getName() + ": C");
                    id = "A";
                    i++;
                    monitor.notifyAll();
                }
        }
    }

    public static void main(String[] args) {
        new PrintA().start();
        new PrintB().start();
        new PrintC().start();
    }

}
