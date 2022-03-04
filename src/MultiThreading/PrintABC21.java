package MultiThreading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName PrintABC21
 * @Date 2021/7/28 17:32
 * @Version 1.0
 */

// 可重入锁
public class PrintABC21 {
    private static Lock lock = new ReentrantLock();
    private static int state = 0;

    private static class MyThread extends Thread{
        private int num = 0;
        private String letter;

        public MyThread(int num, String letter){
            this.num = num;
            this.letter = letter;
        }

        public void run(){

            for(int i = 0; i < 10;){
               // System.out.println(Thread.currentThread().getName() + " :" + i);
                try{
                    lock.lock();
                    if(state % 3 == num){
                      //  System.out.println(Thread.currentThread().getName() + "打印" + letter);
                        System.out.print(letter);
                        state++;
                        i++;  //i ++ 可以写到上面去
                    }
                }finally {
                    lock.unlock();
                }
            }
        }

    }

    public static void main(String[] args) {
        new MyThread(0,"A").start();  //其中i是每个
        new MyThread(1,"B").start();
        new MyThread(2,"C").start();

    }
}
