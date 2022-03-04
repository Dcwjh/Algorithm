package MultiThreading;

import java.util.concurrent.Callable;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName PrintABC3
 * @Date 2021/7/28 18:37
 * @Version 1.0
 */


public class PrintABC3 {
    private static Lock lock = new ReentrantLock();
    private static Condition A = lock.newCondition();
    private static Condition B = lock.newCondition();
    private static Condition C = lock.newCondition();
    private static int count = 0;

    static class ThreadA extends Thread {
        public void run() {
            try {
                lock.lock();
                for (int i = 0; i < 10; i++) {
                    while (count % 3 != 0)  //不满足条件的都要等待
                        A.await();
                    System.out.print("A"); //知道满足条件才进行打印
                    count++;
                    B.signal();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }

    }


    static class ThreadB extends Thread {
        public void run() {
            try {
                lock.lock();
                for (int i = 0; i < 10; ) {
                    while (count % 3 != 1)
                        B.await();
                    System.out.print("B");
                    count++;
                    i++;
                    C.signal();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }

        }

    }

    static class ThreadC extends Thread {
        public void run() {
            try {
                lock.lock();
                for (int i = 0; i < 10; ) {

                    while (count % 3 != 2)
                        C.await();

                    System.out.print("C");
                    count++;
                    i++;
                    A.signal();

                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    static class ThreadTest implements Callable<Integer>{


        @Override
        public Integer call() throws Exception {
            return null;
        }
    }

    public static void main(String[] args) {
        new ThreadA().start();
        new ThreadB().start();
        new ThreadC().start();
    }

}
