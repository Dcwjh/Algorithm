package MultiThreading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName PrintABC2
 * @Date 2021/7/28 17:04
 * @Version 1.0
 */


public class PrintABC2  {
    private static Lock lock = new ReentrantLock();
    private static int state = 0;

    static class print extends Thread {
        private int total;
        private int target;
        private String letter;

        public print(int total, int target, String letter) {
            this.total = total;
            this.target = target;
            this.letter = letter;
        }


        public void run() {
            for (int i = 0; i < total; ) {
                lock.lock();
                try {
                    while (state % 3 == target) { //满足条件操作
                        System.out.print(letter);
                        state++;
                        i++;//变量自增必须写在这
                    }
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    public static void main(String[] args) {
        new print(10, 1, "B").start();
        new print(10, 0, "A").start();
        new print(10, 2, "C").start();
    }

}
