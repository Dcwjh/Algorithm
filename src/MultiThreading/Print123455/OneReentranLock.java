package MultiThreading.Print123455;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class OneReentranLock extends Thread{
    private static Lock lock = new ReentrantLock();// 通过JDK5中的Lock锁来保证线程的访问的互斥
    private static int state = 1;//通过state的值来确定是否打印
    int target;

    OneReentranLock(int target){
        this.target = target;
    }

    @Override
    public void run() {
        for(int i = 1; i < 21; ){
            while(state % 2 == target ){
                lock.lock();
                System.out.println(Thread.currentThread().getName() +":  " +  state);
                state++;
                if(state > 10){
                    state = 1;
                }
                i++;
                lock.unlock();
            }

        }
    }

    public static void main(String[] args) {
        new OneReentranLock(0).start();
        new OneReentranLock(1).start();
    }
}