package MultiThreading.Print123455;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class locklock {
    private static Lock lock = new ReentrantLock();
    private static Condition A = lock.newCondition();
    private static Condition B = lock.newCondition();
    private static Condition C = lock.newCondition();
    static int num = 1;
    static boolean flag = false;

    static class ThreadA extends Thread {
        private int target;

        ThreadA(int target) {
            this.target = target;
        }

        @Override
        public void run() {
            try {
                lock.lock();
                for (int i = 0; i < 4; ) {

                    if (num % 3 != target) {
                        A.await();
                    }
                    if (num < 11) {
                        System.out.println(Thread.currentThread().getName() + ": " + num);
                    }
                    if (num < 10) {
                        num++;
                    } else {
                        num = 1;
                        i++;
                    }
                    B.signal();
                }
                flag = true; // 通知B，C结束
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }


    static class ThreadB extends Thread {
        private int target;

        ThreadB(int target) {
            this.target = target;
        }

        @Override
        public void run() {
            try {
                lock.lock();
                for (int i = 0; i < 4; ) {

                    if (num % 3 != target) {
                        B.await();
                    }
                    if(flag){
                        C.signal(); // 通知C
                        break;
                    }

                    if (num < 11) {
                        System.out.println(Thread.currentThread().getName() + ": " + num);
                    }
                    if (num < 10) {
                        num++;
                    } else {
                        num = 1;
                        i++;
                    }
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
        private int target;

        ThreadC(int target) {
            this.target = target;
        }

        @Override
        public void run() {
            try {
                lock.lock();
                for (int i = 0; i < 4; ) {

                    if (num % 3 != target) {
                        C.await();
                    }
                    if(flag) break;
                    if (num < 11) {
                        System.out.println(Thread.currentThread().getName() + ": " + num);
                    }
                    if (num < 10) {
                        num++;
                    } else {
                        num = 1;
                        i++;
                    }
                    A.signal();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }

        }
    }


    public static void main(String[] args) {
        new ThreadA(1).start();
        new ThreadB(2).start();
        new ThreadC(0).start();
    }
}
