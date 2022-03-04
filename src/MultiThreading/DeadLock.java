package MultiThreading;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName DeadLock
 * @Date 2021/7/28 14:16
 * @Version 1.0
 */


public class DeadLock {
    private static Object a = new Object();
    private static Object b = new Object();

    public static class Thread1 implements Runnable {
        @Override
        public void run() {
            synchronized (a) {
                System.out.println(Thread.currentThread().getName() + "拿到a锁");
                try {
                    Thread.sleep(100);
                    a.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (b){
                    System.out.println(Thread.currentThread().getName() + "拿到b锁");
                }
            }

        }
    }

    public static class Thread2 implements Runnable {
        @Override
        public void run() {
            synchronized (b) {
                System.out.println(Thread.currentThread().getName() + "拿到b锁");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (a){
                    System.out.println(Thread.currentThread().getName() + "拿到a锁");
                    a.notify();

                }

            }

        }
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new Thread1());
        Thread t2 = new Thread(new Thread2());
        t1.setName("线程1： ");
        t2.setName("线程2： ");
        t1.start();
        t2.start();
    }
}
