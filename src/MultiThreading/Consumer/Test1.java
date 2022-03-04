package MultiThreading.Consumer;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName Test1
 * @Date 2021/7/29 16:24
 * @Version 1.0
 */


public class Test1 {
    private static Integer count = 0;
    private static final Integer FULL = 10;
    private static String LOCK = "lock";



    class Producer implements Runnable {
        @Override
        public void run() {
            while(true){
                try {
                    Thread.sleep(200);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                synchronized (LOCK) {
                    while (count == FULL) {
                        try {
                            LOCK.wait();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    count++;
                    System.out.println(Thread.currentThread().getName() + "生产者生产，目前总共有" + count);
                    LOCK.notifyAll();
                }
            }
        }
    }

    class Consumer implements Runnable {
        @Override
        public void run() {
           while(true){
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (LOCK) {
                    while (count == 0) {
                        try {
                            LOCK.wait();
                        } catch (Exception e) {
                        }
                    }
                    count--;
                    System.out.println(Thread.currentThread().getName() + "消费者消费，目前总共有" + count);
                    LOCK.notifyAll();
                }
            }
        }
    }


    public static void main(String[] args) {
        Test1 test1 = new Test1();
        new Thread(test1.new Producer()).start();
        new Thread(test1.new Consumer()).start();
        new Thread(test1.new Producer()).start();
        new Thread(test1.new Consumer()).start();
        new Thread(test1.new Producer()).start();
        new Thread(test1.new Consumer()).start();
        new Thread(test1.new Producer()).start();
        new Thread(test1.new Consumer()).start();
    }

}
