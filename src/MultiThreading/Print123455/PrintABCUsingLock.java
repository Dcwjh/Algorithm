package MultiThreading.Print123455;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName PrintABCUsingLock
 * @Date 2021/7/28 22:04
 * @Version 1.0
 */


public class PrintABCUsingLock {

    private int times; // 控制打印次数
    private int state = 0;   // 当前状态值：保证三个线程之间交替打印
    private int numstate = 1;   // 当前状态值：保证奇偶两个个线程之间交替打印
    public static Lock lock = new ReentrantLock();

    public PrintABCUsingLock(int times) {
        this.times = times;
    }

    private void printLetter(String name, int targetNum) {
        for (int i = 0; i < times; ) {
            lock.lock();
            if (state % 3 == targetNum) {
                state++;
                i++; //必须在lock里面
                System.out.print(name);
            }
            lock.unlock();
        }
    }

    private void printnumber(int targetNum) throws InterruptedException {
        for (int i = 0; i < times; ) {
            lock.lock();
            if(numstate >10){
                numstate = 1;
            }
            if (numstate % 2 == targetNum) {
                System.out.println(Thread.currentThread().getName() + ": " + numstate);
                numstate++;
                i++;
            }
            lock.unlock();

        }
    }

    public static void main(String[] args) {
        PrintABCUsingLock loopThread = new PrintABCUsingLock(20);

            new Thread(() -> {
                try {
                    loopThread.printnumber(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();

            new Thread(() -> {
                try {
                    loopThread.printnumber(0);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();

    }
}
